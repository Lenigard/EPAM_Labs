package by.pavlyut.texthandler.expression;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class NumbersContext {
    LinkedList<Double> numbersList = new LinkedList<>();

    public Double getValue() {
        return numbersList.removeLast();
    }

    public void addValue(Double value) {
        numbersList.add(value);
    }
}

