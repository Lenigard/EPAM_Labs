package by.pavlyut.texthandler.expression;

/**
 * Created by Lenigard on 14.11.2016.
 */
public abstract class AbstractMathOperator {

    private int priority;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public abstract void interpret(NumbersContext context);
}
