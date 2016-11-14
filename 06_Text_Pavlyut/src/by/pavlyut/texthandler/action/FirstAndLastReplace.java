package by.pavlyut.texthandler.action;

import by.pavlyut.texthandler.composite.Component;
import by.pavlyut.texthandler.composite.Compositor;
import by.pavlyut.texthandler.composite.NonSeparatableLeaf;
import by.pavlyut.texthandler.composite.NonSeparatableType;

import java.util.ArrayList;

public class FirstAndLastReplace {

    private void firstAndLastWordsSwap(ArrayList<Component> components) {
        for (Component component : components) {
            if (component.getClass().equals(Compositor.class)) {
                firstAndLastWordsSwap(((Compositor) component).getComponents());
            } else {

                if (NonSeparatableType.WORD.toString().equals(((NonSeparatableLeaf) component).getType())) {
                    components.set(components.indexOf(component), components.get(components.size() - 2));
                    components.set((components.size() - 2), component);
                    return;
                }
            }
        }
    }
}
