package org.example.calculator.domain;

import java.util.List;

import org.example.calculator.domain.operator.AdditionOperatorSign;
import org.example.calculator.domain.operator.DivisionOperatorSign;
import org.example.calculator.domain.operator.MultiplicationOperatorSign;
import org.example.calculator.domain.operator.OperatorSign;
import org.example.calculator.domain.operator.SubtractionOperatorSign;

public class Calculator {

    private static final List<OperatorSign> operatorSigns = List.of(
            new AdditionOperatorSign(),
            new SubtractionOperatorSign(),
            new MultiplicationOperatorSign(),
            new DivisionOperatorSign());

    public static int calculate(final String operator, final PositiveNumber operand1, final PositiveNumber operand2) {
        return operatorSigns.stream()
                .filter(operatorSign -> operatorSign.supports(operator))
                .map(operatorSign -> operatorSign.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산 기호가 아닙니다."));
    }

}
