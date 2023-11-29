package org.example.calculator.domain.operator;

import org.example.calculator.domain.PositiveNumber;

public class MultiplicationOperatorSign implements OperatorSign {

    @Override
    public boolean supports(final String operator) {
        return "*".equals(operator);
    }

    @Override
    public int calculate(final PositiveNumber operand1, final PositiveNumber operand2) {
        return operand1.toInt() * operand2.toInt();
    }

}
