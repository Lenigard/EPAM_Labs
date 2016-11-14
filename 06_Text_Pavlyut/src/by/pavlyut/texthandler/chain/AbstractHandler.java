package by.pavlyut.texthandler.chain;

import by.pavlyut.texthandler.composite.Component;

public abstract class AbstractHandler {

    protected AbstractHandler successor;

    abstract public Component executeText(String text);
}
