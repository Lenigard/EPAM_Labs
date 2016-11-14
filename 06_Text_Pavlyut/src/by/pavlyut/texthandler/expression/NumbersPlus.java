package by.pavlyut.texthandler.expression;

public class NumbersPlus extends AbstractMathOperator {
    @Override
    public void interpret(NumbersContext context) {
        double firstElement = context.getValue();
        double secondElement = context.getValue();
        context.addValue(secondElement + firstElement);
    }
}
