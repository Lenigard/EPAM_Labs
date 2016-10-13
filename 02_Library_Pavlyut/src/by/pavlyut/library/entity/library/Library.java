package by.pavlyut.library.entity.library;

import by.pavlyut.library.comparator.AlbomComparator;
import by.pavlyut.library.comparator.BookComparator;
import by.pavlyut.library.comparator.ComixComparator;
import by.pavlyut.library.comparator.MagazineComparator;
import by.pavlyut.library.entity.literature.Albom;
import by.pavlyut.library.entity.literature.Book;
import by.pavlyut.library.entity.literature.Comix;
import by.pavlyut.library.entity.literature.Magazine;


import java.util.LinkedList;

public class Library {
    private LinkedList<Magazine> magazines;
    private LinkedList<Albom> alboms;
    private LinkedList<Comix> comix;
    private LinkedList<Book> books;
    private AlbomComparator albomComp;
    private BookComparator bookComp;
    private ComixComparator comixComp;
    private MagazineComparator magazineComp;

    public Library() {
        magazines = new LinkedList<>();
        alboms = new LinkedList<>();
        comix = new LinkedList<>();
        books = new LinkedList<>();
        albomComp = new AlbomComparator();
        bookComp = new BookComparator();
        comixComp = new ComixComparator();
        magazineComp = new MagazineComparator();
    }

    public void addMagazine(Magazine newMagazine) {
        int size = magazines.size();
        switch (size) {
            case 0: {
                magazines.add(0, newMagazine);
                break;
            }
            case 1: {
                if (magazineComp.compare(newMagazine, magazines.get(0)) > 0) {
                    magazines.add(1, newMagazine);
                }
                break;
            }
            default: {
                int i = 0;
                while ((i < magazines.size() - 1) || (magazineComp.compare(newMagazine, magazines.get(i)) < 0)) {
                    i++;
                }
                magazines.add(i, newMagazine);
                break;
            }
        }
    }

    public void addAlbom(Albom newAlbom) {
        int size = alboms.size();
        switch (size) {
            case 0: {
                alboms.add(0, newAlbom);
                break;
            }
            case 1: {
                if (albomComp.compare(newAlbom, alboms.get(0)) > 0) {
                    alboms.add(1, newAlbom);
                }
                break;
            }
            default: {
                int i = 0;
                while ((i < alboms.size() - 1) || (albomComp.compare(newAlbom, alboms.get(i)) < 0)) {
                    i++;
                }
                alboms.add(i, newAlbom);
                break;
            }
        }
    }

    public void addComix(Comix newComix) {
        int size = comix.size();
        switch (size) {
            case 0: {
                comix.add(newComix);

                break;
            }
            case 1: {
                if (comixComp.compare(newComix, comix.get(0)) > 0) {
                    comix.add(1, newComix);
                }
                break;
            }
            default: {
                int i = 0;
                while ((i < comix.size() - 1) || (comixComp.compare(newComix, comix.get(i)) < 0)) {
                    i++;
                }
                comix.add(i, newComix);
                break;
            }
        }
    }

    public void addBook(Book newBook) {
        int size = books.size();
        switch (size) {
            case 0: {
                books.add(0, newBook);
                break;
            }
            case 1: {
                if (bookComp.compare(newBook, books.get(0)) > 0) {
                    books.add(1, newBook);
                }
                break;
            }
            default: {
                int i = 0;
                while ((i < books.size() - 1) || (bookComp.compare(newBook, books.get(i)) < 0)) {
                    i++;
                }
                books.add(i, newBook);
                break;
            }
        }
    }

    public Comix getComix(int index) {
        return comix.get(index);
    }

    public Book getBook(int index) {
        return books.get(index);
    }

    public Albom getAlbom(int index) {
        return alboms.get(index);
    }

    public Magazine getMagazine(int index) {
        return magazines.get(index);
    }

    public int getComixSize() {
        return comix.size();
    }

    public int getBookSize() {

        return books.size();
    }

    public int getAlbomSize() {
        return alboms.size();
    }

    public int getMagazineSize() {
        return magazines.size();
    }


    public void info() {
        for (int i = 0; i < magazines.size(); i++) {
            System.out.print(magazines.get(i).toString());
        }
        for (int i = 0; i < alboms.size(); i++) {
            System.out.print(alboms.get(i).toString());
        }
        for (int i = 0; i < comix.size(); i++) {
            System.out.print(comix.get(i).toString());
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).toString());
        }
    }
}
