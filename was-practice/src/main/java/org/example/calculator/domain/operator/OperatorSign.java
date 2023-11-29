package org.example.calculator.domain.operator;

import org.example.calculator.domain.PositiveNumber;

public interface OperatorSign {

    boolean supports(final String operator);

    int calculate(final PositiveNumber operand1, final PositiveNumber operand2);

}
