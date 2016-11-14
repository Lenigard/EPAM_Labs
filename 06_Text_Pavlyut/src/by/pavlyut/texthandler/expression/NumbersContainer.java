package by.pavlyut.texthandler.expression;

public class NumbersContainer extends AbstractMathOperator {
    private double number;

    public NumbersContainer(double number) {
        this.number = number;
    }

    @Override
    public void interpret(NumbersContext context) {
        context.addValue(number);
    }
}
