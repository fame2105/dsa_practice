package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TextFileParser implements Parser{
    private File file;

    public TextFileParser(File file) {
        System.out.println("Creating Text parser");
        this.file = file;
    }

    public List<Record> parse() {
        System.out.println("parsing text file");
        return new ArrayList<>();
    }
}
