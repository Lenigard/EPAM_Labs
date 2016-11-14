package by.pavlyut.texthandler.composite;

public interface Component {
    void add(Component component);
    Object getSubline(int index);
}
