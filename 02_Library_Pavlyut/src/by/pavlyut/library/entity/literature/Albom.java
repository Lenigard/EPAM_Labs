package by.pavlyut.library.entity.literature;

import java.util.LinkedList;

public class Albom {
    private String title;
    private int pages;
    private String genre;
    private int photosCount;
    private LinkedList<String> photographers;

    public Albom(int pages, int photosCount, String genrem, String title, LinkedList<String> photographers) {
        this.photographers = new LinkedList<>();
        this.pages = pages;
        this.photosCount = photosCount;
        this.genre = genrem;
        this.title = title;
        this.photographers = (LinkedList) photographers.clone();
    }

    public Albom(String[] arguments){
        photographers = new LinkedList<>();
        if(arguments.length >= 6) {
            title = arguments[1];
            pages = Integer.parseInt(arguments[2]);
            genre = arguments[3];
            photosCount = Integer.parseInt(arguments[4]);
            for(int i = 5; i < arguments.length; i ++) {
                photographers.add(arguments[i]);
            }
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Тип: альбом.\n");
        result.append("Название: " + title + ".\n");
        result.append("Жанр: " + genre + ".\n");
        result.append("Количество страниц:" + pages + ".\n");
        result.append("Количество фотографи: " + photosCount + ".\n");
        result.append("Имена фотографов: ");
        for (int i = 0; i < photographers.size(); i++) {
            result.append(photographers.get(i) + " ");
        }
        result.append("\n\n");
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
