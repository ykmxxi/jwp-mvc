package org.example.calculator;

import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.example.calculator.view.InputView;
import org.example.calculator.view.OutputView;

/**
 * 사칙연산 계산기
 * - 간단한 사칙연산만 가능
 * - 양수로만 계산 가능
 * - 나눗셈의 분모가 0이면 IllegalArgumentException 발생
 * - MVC 패턴 기반으로 구현
 */
public class CalculatorApplication {

    public static void main(String[] args) {
        String operator = InputView.readOperator();
        PositiveNumber operand1 = new PositiveNumber(InputView.readOperand());
        PositiveNumber operand2 = new PositiveNumber(InputView.readOperand());

        int result = Calculator.calculate(operator, operand1, operand2);

        OutputView.printResult(result);
    }

}
