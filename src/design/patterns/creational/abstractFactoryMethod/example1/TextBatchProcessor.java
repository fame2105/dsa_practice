package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;

public class TextBatchProcessor extends BatchProcessor {
    private File file;

    public TextBatchProcessor(File file) {
        this.file = file;
    }

    @Override
    public Parser createParser(File file) {
        return new TextFileParser(this.file);
    }
}
