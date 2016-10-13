package by.pavlyut.library.main;

import by.pavlyut.library.entity.library.Library;
import by.pavlyut.library.factory.LibraryFactory;
import by.pavlyut.library.factory.fileread.FileRead;

public class Main {



    public static void main(String args[]) {
        Library library = new Library();
        FileRead fileReader = new FileRead();
        library = fileReader.readLibrary();
        LibraryFactory factory = new LibraryFactory();
        fileReader.searchInLibrary(factory, library);
    }
}

