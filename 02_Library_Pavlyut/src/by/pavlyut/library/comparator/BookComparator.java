package by.pavlyut.library.comparator;

import by.pavlyut.library.entity.literature.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPages() - o2.getPages();
    }
}
