package by.pavlyut.texthandler.expression;

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
