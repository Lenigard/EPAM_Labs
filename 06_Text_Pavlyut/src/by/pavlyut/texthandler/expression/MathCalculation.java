package by.pavlyut.texthandler.expression;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.pavlyut.texthandler.exception.CalculatingEquationException;

public class MathCalculation{

    private final String INCREMENT_DECREMET_REGEX = "(\\d*)(\\+\\+|\\-\\-)(\\d*)";
    private final static Logger LOG = LogManager.getLogger(MathCalculation.class.getName());

    boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int incremented(String increment) {
        return Integer.parseInt(increment) + 1;
    }

    private int decremented(String decrement) {
        return Integer.parseInt(decrement) - 1;
    }

    private String replaceIncrementDecrement(String inputString) {
        Pattern p = Pattern.compile(INCREMENT_DECREMET_REGEX);
        Matcher m = p.matcher(inputString);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            int result;
            if (m.group(2).equals("++")) {
                result = (m.group(1).isEmpty()) ? incremented(m.group(3)) : incremented(m.group(1));
            } else {
                result = (m.group(1).isEmpty()) ? decremented(m.group(3)) : decremented(m.group(1));
            }
            m.appendReplacement(sb, String.valueOf(result));

        }
        m.appendTail(sb);
        return sb.toString();
    }

    private int priority(char operator) {
        switch (operator) {
            case '*':
            case '/':
                return 1;
            case '+':
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    private void countSeparatedExpression(NumbersContext elements, char operator) {
        switch (operator) {
            case '+':
                new NumbersPlus().interpret(elements);
                break;
            case '-':
                new NumbersMinus().interpret(elements);
                break;
            case '*':
                new NumbersMultiply().interpret(elements);
                break;
            case '/':
                new NumbersDivide().interpret(elements);
                break;
            default:
                LOG.error("Wrong equation.");
        }
    }

    public double convert(String inputString) throws CalculatingEquationException{
        replaceIncrementDecrement(inputString);
        inputString = replaceIncrementDecrement(inputString);
        NumbersContext doublesContext = new NumbersContext();
        LinkedList<Character> operatorsList = new LinkedList<>();
        for (int i = 0; i < inputString.length(); i++) {
            char inputChar = inputString.charAt(i);
            if (inputChar == '(') {
                operatorsList.add('(');
            } else if (inputChar == ')') {
                while (operatorsList.getLast() != '(') {
                    countSeparatedExpression(doublesContext, operatorsList.removeLast());
                }
                operatorsList.removeLast();
            } else if (isOperator(inputChar)) {
                while (!operatorsList.isEmpty() && priority(operatorsList.getLast()) >= priority(inputChar)) {
                    countSeparatedExpression(doublesContext, operatorsList.removeLast());
                }
                operatorsList.add(inputChar);
            } else {
                String operand = new String();
                while (i < inputString.length() && Character.isDigit(inputString.charAt(i))) {
                    operand += inputString.charAt(i++);
                }
                --i;
                doublesContext.addValue(Double.parseDouble(operand));
            }
        }
        while (!operatorsList.isEmpty()) {
            countSeparatedExpression(doublesContext, operatorsList.removeLast());
        }
        return doublesContext.getValue();
    }

}
