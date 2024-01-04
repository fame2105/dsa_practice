package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;

public class CSVBatchProcessor extends BatchProcessor{
    private File file;

    public CSVBatchProcessor(File file) {
        this.file = file;
    }

    @Override
    public Parser createParser(File file) {
        return new CSVFileParser(this.file);
    }
}
