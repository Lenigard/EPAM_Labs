package by.pavlyut.texthandler.expression;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class NumbersMinus extends AbstractMathOperator{

    @Override
    public void interpret(NumbersContext context) {
        double firstElement = context.getValue();
        double secondElement = context.getValue();
        context.addValue(secondElement - firstElement);
    }
}
