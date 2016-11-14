package by.pavlyut.texthandler.exception;

public class CalculatingEquationException extends Exception {
    private String equation;

    public CalculatingEquationException(String msg, String equation){
        super(msg);
        this.equation = equation;
    }

}
