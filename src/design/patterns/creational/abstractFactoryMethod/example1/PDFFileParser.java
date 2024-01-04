package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PDFFileParser implements Parser{
    private File file;

    public PDFFileParser(File file) {
        System.out.println("Creating PDF parser");
        this.file = file;
    }

    @Override
    public List<Record> parse() {
        System.out.println("parsing pdf file");
        return new ArrayList<>();
    }
}
