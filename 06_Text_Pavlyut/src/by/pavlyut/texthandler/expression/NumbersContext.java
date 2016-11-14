package by.pavlyut.texthandler.expression;

import java.util.LinkedList;

public class NumbersContext {
    LinkedList<Double> numbersList = new LinkedList<>();

    public Double getValue() {
        return numbersList.removeLast();
    }

    public void addValue(Double value) {
        numbersList.add(value);
    }
}

