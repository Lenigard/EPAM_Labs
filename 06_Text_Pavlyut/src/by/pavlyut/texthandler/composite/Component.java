package by.pavlyut.texthandler.composite;

/**
 * Created by Lenigard on 03.11.2016.
 */
public interface Component {
    void add(Component component);
    Object getSubline(int index);
}
