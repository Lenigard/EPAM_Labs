package by.pavlyut.texthandler.chain;

import by.pavlyut.texthandler.composite.Component;
import by.pavlyut.texthandler.composite.NonSeparatableLeaf;
import by.pavlyut.texthandler.composite.NonSeparatableType;
import by.pavlyut.texthandler.expression.MathCalculation;

import java.util.regex.Pattern;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class TerminalHandler extends AbstractHandler {

    private final Pattern WORD_PATTERN = Pattern.compile("(\\w+)\n");
    private final Pattern MATH_PATTERN = Pattern.compile("([\\(\\d]+[\\+*\\-+/\\)]*)+");

    private static NonSeparatableType type;

    @Override
    public Component executeText(String text) {

        if (WORD_PATTERN.matcher(text).matches()) {
            type = NonSeparatableType.WORD;
        } else if (MATH_PATTERN.matcher(text).matches()) {
            MathCalculation converter = new MathCalculation();
            text = String.valueOf((converter.convert(text)));
            type = NonSeparatableType.NUMBER;
        } else {
            type = NonSeparatableType.DELIMITER;
        }
        return new NonSeparatableLeaf(text, type);
    }
}
