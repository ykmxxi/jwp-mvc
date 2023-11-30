package org.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    public void init(final ServletConfig config) throws ServletException {
        logger.info("init()");
    }

    @Override
    public void service(final ServletRequest req, final ServletResponse res) throws ServletException, IOException {
        logger.info("service()");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int result = Calculator.calculate(operator, new PositiveNumber(operand1), new PositiveNumber(operand2));

        PrintWriter writer = res.getWriter();
        writer.println(result);
    }

    @Override
    public void destroy() {
        logger.info("destroy()");
    }

    @Override
    public ServletConfig getServletConfig() {
        logger.info("getServletConfig()");
        return null;
    }

    @Override
    public String getServletInfo() {
        logger.info("getServletInfo()");
        return null;
    }

}
