package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CSVFileParser implements Parser{
    private File file;

    public CSVFileParser(File file) {
        System.out.println("Creating CSV parser");
        this.file = file;
    }

    @Override
    public List<Record> parse() {
        System.out.println("parsing CSV file");
        return new ArrayList<>();
    }
}
