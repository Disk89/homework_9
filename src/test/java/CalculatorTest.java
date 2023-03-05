import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;


class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @ParameterizedTest
    @MethodSource("operatorAndVariables")
    void calc(BinaryOperator<Integer> operator, int a, int b, Integer expected) {
        Integer actual = calculator.calc(operator, a, b);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> operatorAndVariables() {
        BinaryOperator<Integer> plus = Integer::sum;
        BinaryOperator<Integer> minus = (a, b) -> a - b;
        BinaryOperator<Integer> multiply = (a, b) -> a * b;
        BinaryOperator<Integer> divide = (a, b) -> a / b;
        return Stream.of(
                Arguments.of(plus, 2, 5, 7),
                Arguments.of(minus, 12, 5, 7),
                Arguments.of(multiply, 2, 5, 10),
                Arguments.of(divide, 12, 5, 2)
        );
    }

}