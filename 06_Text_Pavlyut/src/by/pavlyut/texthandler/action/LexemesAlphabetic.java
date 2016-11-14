package by.pavlyut.texthandler.action;

import by.pavlyut.texthandler.composite.Component;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class LexemesAlphabetic {
    public void inAlphabeticOrder(ArrayList<Component> components){
        LinkedList<Double> numbersList = new LinkedList<>();
        for(Component comp : components){
            System.out.println(comp.getClass());
        }
    }
}
