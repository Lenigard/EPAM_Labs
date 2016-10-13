package by.pavlyut.library.entity.literature;

import java.util.LinkedList;

public class Magazine {
    private int pages;
    private String genre;
    private String title;
    private String mainRedactor;
    private int number;
    private int year;

    public Magazine(int pages, String genre, String title, String mainRedactor, int number, int year) {
        this.pages = pages;
        this.mainRedactor = mainRedactor;
        this.genre = genre;
        this.title = title;
        this.number = number;
        this.year = year;
    }

    public Magazine(String[] arguments){
        if(arguments.length == 7) {
            title = arguments[1];
            pages = Integer.parseInt(arguments[2]);
            genre = arguments[3];
            mainRedactor = arguments[4];
            number = Integer.parseInt(arguments[5]);
            year = Integer.parseInt(arguments[6]);
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Тип: журнал.\n");
        result.append("Название: " + title + ".\n");
        result.append("Жанр: " + genre + ".\n");
        result.append("Количество страниц:" + pages + ".\n");
        result.append("Главный редактор: " + mainRedactor + ".\n");
        result.append("Номер издания: " + number + ".\n");
        result.append("Год издания: " + year + ".\n");
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
