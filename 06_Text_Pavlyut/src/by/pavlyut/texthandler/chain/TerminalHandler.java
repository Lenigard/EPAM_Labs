package by.pavlyut.texthandler.chain;

import by.pavlyut.texthandler.composite.Component;
import by.pavlyut.texthandler.composite.NonSeparatableLeaf;
import by.pavlyut.texthandler.composite.NonSeparatableType;
import by.pavlyut.texthandler.exception.CalculatingEquationException;
import by.pavlyut.texthandler.expression.MathCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class TerminalHandler extends AbstractHandler {

    private final Pattern WORD_PATTERN = Pattern.compile("(\\w+)\n");
    private final Pattern MATH_PATTERN = Pattern.compile("([\\(\\d]+[\\+*\\-+/\\)]*)+");

    private static NonSeparatableType type;
    private final static Logger LOG = LogManager.getLogger(NonSeparatableLeaf.class.getName());

    @Override
    public Component executeText(String text) {
        if (WORD_PATTERN.matcher(text).matches()) {
            type = NonSeparatableType.WORD;
        } else if (MATH_PATTERN.matcher(text).matches()) {
            MathCalculation converter = new MathCalculation();
            try {
                text = String.valueOf((converter.convert(text)));
            } catch (CalculatingEquationException e) {
                LOG.error(e);
            }
            type = NonSeparatableType.NUMBER;
        } else {
            type = NonSeparatableType.DELIMITER;
        }
        return new NonSeparatableLeaf(text, type);
    }
}
