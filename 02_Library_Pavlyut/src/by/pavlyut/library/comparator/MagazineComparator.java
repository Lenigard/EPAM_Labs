package by.pavlyut.library.comparator;

import by.pavlyut.library.entity.literature.Magazine;

import java.util.Comparator;

/**
 * Created by Lenigard on 10.10.2016.
 */
public class MagazineComparator implements Comparator<Magazine> {

    @Override
    public int compare(Magazine o1, Magazine o2) {
        return o1.getPages() - o2.getPages();
    }
}