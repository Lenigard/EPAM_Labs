package by.pavlyut.library.entity.literature;

public class Book {
    private int pages;
    private String genre;
    private String title;
    private String publishing;
    private int year;

    public Book(int pages, String publishing, String genrem, String title, int year) {
        this.pages = pages;
        this.publishing = publishing;
        this.genre = genrem;
        this.title = title;
        this.year = year;
    }

    public Book(String[] arguments) {
        if (arguments.length == 6) {
            title = arguments[1];
            pages = Integer.parseInt(arguments[2]);
            genre = arguments[3];
            publishing = arguments[4];
            year = Integer.parseInt(arguments[5]);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Тип: книга.\n");
        result.append("Название: " + title + ".\n");
        result.append("Жанр: " + genre + ".\n");
        result.append("Количество страниц:" + pages + ".\n");
        result.append("Изадетльство: " + publishing + ".\n");
        result.append("Год издания: " + year + ".\n");
        result.append("\n");
        return result.toString();
    }

    public int getPages() {
        return pages;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

}
