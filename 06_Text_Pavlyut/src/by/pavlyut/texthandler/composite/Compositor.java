package by.pavlyut.texthandler.composite;

import java.util.ArrayList;

public class Compositor implements Component {

    private ArrayList<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public Object getSubline(int index) {
        return components.get(index).getSubline(index);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < components.size(); i++) {
            sb.append(components.get(i));
        }
        return sb.toString();
    }

    public ArrayList<Component> getComponents(){
        return components;
    }

}
