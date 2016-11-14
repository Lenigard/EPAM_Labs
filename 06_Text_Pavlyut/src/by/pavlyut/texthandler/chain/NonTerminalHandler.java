package by.pavlyut.texthandler.chain;

import by.pavlyut.texthandler.composite.Component;
import by.pavlyut.texthandler.composite.Compositor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NonTerminalHandler extends AbstractHandler {

    private Pattern currentPattern;
    private Component component;

    public NonTerminalHandler(String regex) {
        super.successor = new TerminalHandler();
        this.currentPattern = Pattern.compile(regex);
    }

    public NonTerminalHandler(AbstractHandler successor, String regex) {
        super.successor = successor;
        this.currentPattern = Pattern.compile(regex);
    }

    @Override
    public Component executeText(String text) {
        component = new Compositor();
        Matcher matcher = currentPattern.matcher(text);
        while (matcher.find()){
            component.add(successor.executeText(matcher.group()));
        }
        return component;
    }
}
