package org.example;

import java.io.IOException;

/**
 * GET /calculate?operand1=10&operator=*&operand2=20
 */
public class CalculatorWebApplication {

    public static void main(String[] args) throws IOException {
        CustomWebApplicationServer applicationServer = new CustomWebApplicationServer(8080);
        applicationServer.start();
    }

}
