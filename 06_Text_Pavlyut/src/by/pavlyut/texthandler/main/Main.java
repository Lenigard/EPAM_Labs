package by.pavlyut.texthandler.main;

import by.pavlyut.texthandler.action.LexemesAlphabetic;
import by.pavlyut.texthandler.chain.AbstractHandler;
import by.pavlyut.texthandler.chain.NonTerminalHandler;
import by.pavlyut.texthandler.composite.Component;
import by.pavlyut.texthandler.textread.TextReader;

/**
 * Created by Lenigard on 03.11.2016.
 */
public class Main {

    private final static String PARAGRAPH_REGEX = "(\\t.+)";
    private final static String SENTENCES_REGEX = "(([A-Z]([^?!.\\(]|\\([^\\)]*\\))*[.?!] ?))";
    private final static String LEXEMES_REGEX = "([a-zA-Z]+|[\\S]+|[ ]+)";


    public static void main(String args[]){
        TextReader textreader = new TextReader();
        String readedText = textreader.textRead();
        AbstractHandler sentences = new NonTerminalHandler(LEXEMES_REGEX);
        AbstractHandler paragraphs = new NonTerminalHandler(sentences, SENTENCES_REGEX);
        AbstractHandler text = new NonTerminalHandler(paragraphs, PARAGRAPH_REGEX);
        Component textComposite = text.executeText(readedText);
        System.out.println(textComposite.toString());
        LexemesAlphabetic lexemes = new LexemesAlphabetic();
    }
}
