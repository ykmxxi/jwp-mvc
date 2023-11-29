package org.example;

import java.io.DataOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpResponse {

    private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final DataOutputStream dos;

    public HttpResponse(final DataOutputStream dos) {
        this.dos = dos;
    }

    public void response200Header(final String contentType, final int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK " + LINE_SEPARATOR);
            dos.writeBytes("Content-Type: " + contentType + ";charset=utf-8" + LINE_SEPARATOR);
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + LINE_SEPARATOR);
            dos.writeBytes(LINE_SEPARATOR);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public void responseBody(final byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

}
