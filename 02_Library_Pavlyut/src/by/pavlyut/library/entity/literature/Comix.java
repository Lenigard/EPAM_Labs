package by.pavlyut.library.entity.literature;

import java.util.LinkedList;

public class Comix {
    private int pages;
    private String genre;
    private String title;
    private String company;
    LinkedList<String> heroes;

    public Comix(int pages, String company, String genrem, String title, LinkedList<String> heroes) {
        this.heroes = new LinkedList<String>();
        this.pages = pages;
        this.company = company;
        this.genre = genrem;
        this.title = title;
        this.heroes = (LinkedList) heroes.clone();
    }

    public Comix(String[] arguments){
        heroes = new LinkedList<>();
        if(arguments.length >= 6) {
            title = arguments[1];
            pages = Integer.parseInt(arguments[2]);
            genre = arguments[3];
            company = arguments[4];
            for(int i = 5; i < arguments.length; i ++) {
                heroes.add(arguments[i]);
            }
        }
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Тип: комикс.\n");
        result.append("Название: " + title + ".\n");
        result.append("Жанр: " + genre + ".\n");
        result.append("Количество страниц:" + pages + ".\n");
        result.append("Компания: " + company + ".\n");
        result.append("Герои: ");
        for (int i = 0; i < heroes.size(); i++) {
            result.append(heroes.get(i) + " ");
        }
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
