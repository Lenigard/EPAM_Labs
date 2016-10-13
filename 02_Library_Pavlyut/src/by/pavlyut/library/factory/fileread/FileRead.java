package by.pavlyut.library.factory.fileread;

import by.pavlyut.library.entity.library.Library;
import by.pavlyut.library.entity.literature.Albom;
import by.pavlyut.library.entity.literature.Book;
import by.pavlyut.library.entity.literature.Comix;
import by.pavlyut.library.entity.literature.Magazine;
import by.pavlyut.library.factory.LibraryFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRead {

    private final static String LIBRARYFILE = "file\\library.txt";
    private final static String SEARCHFILE = "file\\search.txt";
    private final static String RESULTFILE = "file\\result.txt";
    private final static Logger LOG = LogManager.getLogger();

    public Library readLibrary() {
        Library library = new Library();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(LIBRARYFILE));
            String sCurrentLine;
            String[] parameters;
            while ((sCurrentLine = br.readLine()) != null) {
                parameters = sCurrentLine.split(" ");
                switch (parameters[0]) {
                    case "Альбом":
                        library.addAlbom(new Albom(parameters));
                        break;
                    case "Журнал":
                        library.addMagazine(new Magazine(parameters));
                        break;
                    case "Книга":
                        library.addBook(new Book(parameters));
                        break;
                    case "Комикс":
                        library.addComix(new Comix(parameters));
                        break;
                    default:
                        break;
                }
            }
            br.close();
        } catch (IOException e) {
            LOG.error("Ошибка файла: неверно задан входной файл библиотеки.");
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                else throw new IOException();
            } catch (IOException e) {
                LOG.error("Ошибка файла: удаление входного файла библиотеки произошло неверно.");

            }
            return library;
        }
    }

    public void searchInLibrary(LibraryFactory factory, Library library) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(SEARCHFILE));
            String sCurrentLine;
            String[] parameters;
            while ((sCurrentLine = br.readLine()) != null) {
                parameters = sCurrentLine.split(" ");
                StringBuilder result = new StringBuilder();
                if (parameters.length == 4) {
                    factory.literatureSearch(library, parameters, result);
                    writingResult(result);
                }
            }
            br.close();
        } catch (IOException e) {
            LOG.error("Ошибка файла: неверно задан входной файл поиска.");
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                LOG.error("Ошибка файла: удаление входного файла поиска произошло неверно.");
            }
        }
    }

    void writingResult(StringBuilder result) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(RESULTFILE));
            bw.write(result.toString());
            bw.close();
        } catch (IOException e) {
            LOG.error("Ошибка файла: неверно задан выходной файл поиска.");
        } finally {
            try {
                if(bw != null) {
                    bw.close();
                }
                else {
                    throw  new IOException();
                }
            } catch (IOException e) {
                LOG.error("Ошибка файла: удаление выходного файла поиска произошло неверно.");
            }
        }
    }
}