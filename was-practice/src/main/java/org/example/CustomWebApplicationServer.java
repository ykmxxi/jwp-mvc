package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomWebApplicationServer {

    private static final Logger log = LoggerFactory.getLogger(CustomWebApplicationServer.class);
    private static final int THREAD_COUNT = 10;

    private final int port;
    private final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT); // 쓰레드 풀

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

                // step2: 사용자 요청이 들어올 때마다 Thread를 새로 생성해서 사용자 요청을 처리
                handleClientRequestInHandler(clientSocket);
            }
        }
    }

    private void handleClientRequestInHandler(final Socket clientSocket) throws IOException {
        executorService.execute(new ClientRequestHandler(clientSocket));
    }

}
