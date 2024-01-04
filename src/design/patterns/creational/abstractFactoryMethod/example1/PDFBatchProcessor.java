package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;

public class PDFBatchProcessor extends BatchProcessor {
    private File file;

    public PDFBatchProcessor(File file) {
        this.file = file;
    }

    @Override
    public Parser createParser(File file) {
        return new PDFFileParser(this.file);
    }
}
