package by.pavlyut.texthandler.exception;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class CalculatingEquationException extends Exception {
    private String equation;

    public CalculatingEquationException(String msg, String equation){
        super(msg);
        this.equation = equation;
    }

}
