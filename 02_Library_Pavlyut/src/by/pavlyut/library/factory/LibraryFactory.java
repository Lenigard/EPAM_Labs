package by.pavlyut.library.factory;

import by.pavlyut.library.entity.library.Library;
import by.pavlyut.library.entity.literature.Albom;
import by.pavlyut.library.entity.literature.Book;
import by.pavlyut.library.entity.literature.Comix;
import by.pavlyut.library.entity.literature.Magazine;

public class LibraryFactory {

    public void literatureSearch(Library library, String[] searchingParameters, StringBuilder result) {
        boolean correctLiterature = false;
        for (int i = 0; i < library.getComixSize(); i++) {
            Comix curComix = library.getComix(i);
            correctLiterature = search(curComix.getTitle(), curComix.getPages(), curComix.getGenre(), searchingParameters);
            if(correctLiterature) {
                result.append(curComix.toString());
            }
        }
        for (int i = 0; i < library.getMagazineSize(); i++) {
            Magazine curMagazine = library.getMagazine(i);
            correctLiterature = search(curMagazine.getTitle(), curMagazine.getPages(), curMagazine.getGenre(), searchingParameters);
            if(correctLiterature) {
                result.append(curMagazine.toString());
            }
        }
        for (int i = 0; i < library.getAlbomSize(); i++) {
            Albom curAlbom = library.getAlbom(i);
            correctLiterature = search(curAlbom.getTitle(), curAlbom.getPages(), curAlbom.getGenre(), searchingParameters);
            if(correctLiterature) {
                result.append(curAlbom.toString());
            }
        }
        for (int i = 0; i < library.getBookSize(); i++) {
            Book curBook = library.getBook(i);
            correctLiterature = search(curBook.getTitle(), curBook.getPages(), curBook.getGenre(), searchingParameters);
            if(correctLiterature) {
                result.append(curBook.toString());
            }
        }
    }

    boolean search(String curTitle, int curPages, String curGenre, String[] searchingParameters) {
        boolean correctLiterature = true;
        if (!searchingParameters[0].equals("None")) {
            if (!curTitle.equals(searchingParameters[0])) {
                correctLiterature = false;
            }
        }
        if (!searchingParameters[1].equals("None") && correctLiterature) {
            if (curPages < Integer.parseInt(searchingParameters[1])) {
                correctLiterature = false;
            }
        }
        if (!searchingParameters[2].equals("None") && correctLiterature) {
            if (curPages > Integer.parseInt(searchingParameters[2])) {
                correctLiterature = false;
            }
        }
        if (searchingParameters[3].equals("None") && correctLiterature) {
            if (curGenre.equals(searchingParameters[3])) {
                correctLiterature = false;
            }
        }
        return correctLiterature;
    }
}
