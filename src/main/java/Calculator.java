import java.util.function.BinaryOperator;

public class Calculator {

    public Integer calc(BinaryOperator<Integer> function, int a, int b) {
        return function.apply(a, b);
    }

}
