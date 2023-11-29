package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientRequestHandler implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(ClientRequestHandler.class);

    private final Socket clientSocket;

    public ClientRequestHandler(final Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        log.info("[ClientRequestHandler] new client {} started", Thread.currentThread().getName());
        try (
                InputStream in = clientSocket.getInputStream();
                OutputStream out = clientSocket.getOutputStream()
        ) {
            BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
            DataOutputStream dos = new DataOutputStream(out);

            HttpRequest httpRequest = new HttpRequest(br);

            if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                QueryStrings queryStrings = httpRequest.getQueryStrings();

                int operand1 = Integer.parseInt(queryStrings.getValue("operand1"));
                String operator = queryStrings.getValue("operator");
                int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));

                int result = Calculator.calculate(operator, new PositiveNumber(operand1), new PositiveNumber(operand2));
                byte[] body = String.valueOf(result).getBytes();

                createHttpResponse(dos, body);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void createHttpResponse(final DataOutputStream dos, final byte[] body) {
        HttpResponse httpResponse = new HttpResponse(dos);
        httpResponse.response200Header("application/json", body.length);
        httpResponse.responseBody(body);
    }

}
