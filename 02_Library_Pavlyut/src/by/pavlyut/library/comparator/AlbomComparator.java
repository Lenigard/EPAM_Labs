package by.pavlyut.library.comparator;

import by.pavlyut.library.entity.literature.Albom;

import java.util.Comparator;

/**
 * Created by Lenigard on 10.10.2016.
 */
public class AlbomComparator implements Comparator<Albom> {

    @Override
    public int compare(Albom o1, Albom o2) {
        return o1.getPages() - o2.getPages();
    }
}
