package by.pavlyut.texthandler.textread;

import by.pavlyut.texthandler.expression.MathCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by Lenigard on 14.11.2016.
 */
public class TextReader {

    private final static Logger LOG = LogManager.getLogger(TextReader.class.getName());
    private final String TEXT_PATH = "files/text.txt";

    public String textRead() {
        try {
            return Files.lines(Paths.get(TEXT_PATH)).map(i -> i.toString()).collect(Collectors.joining());
        } catch (IOException e) {
            LOG.error("Exception in file reader.");
        }
        return "";
    }
}

