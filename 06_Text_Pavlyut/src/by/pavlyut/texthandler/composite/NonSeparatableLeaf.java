package by.pavlyut.texthandler.composite;

/**
 * Created by Lenigard on 10.11.2016.
 */
public class NonSeparatableLeaf implements Component {
    private String value;
    private NonSeparatableType type;

    public NonSeparatableLeaf(String value, NonSeparatableType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public Object getSubline(int index) {
        return getValue();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public NonSeparatableType getType() {
        return type;
    }

    public void setType(NonSeparatableType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
