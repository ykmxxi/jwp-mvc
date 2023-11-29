package org.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    private final int port;

    public CustomWebApplicationServer(final int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ) {
            log.info("[CustomWebApplicationServer] started {} port", port);

            Socket clientSocket;
            log.info("[CustomWebApplicationServer] waiting for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                log.info("[CustomWebApplicationServer] client connected");

                // step1: 사용자 요청을 메인 Thread가 처리
                handleClientRequestInMainThread(clientSocket);
            }
        }
    }

    private void handleClientRequestInMainThread(final Socket clientSocket) throws IOException {
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

                HttpResponse httpResponse = new HttpResponse(dos);
                httpResponse.response200Header("application/json", body.length);
                httpResponse.responseBody(body);
            }
        }
    }

}
