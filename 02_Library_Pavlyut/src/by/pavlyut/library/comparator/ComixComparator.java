package by.pavlyut.library.comparator;

import by.pavlyut.library.entity.literature.Comix;

import java.util.Comparator;

/**
 * Created by Lenigard on 10.10.2016.
 */
public class ComixComparator implements Comparator<Comix> {

    @Override
    public int compare(Comix o1, Comix o2) {
        return o1.getPages() - o2.getPages();
    }
}