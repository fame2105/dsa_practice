package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;
import java.util.List;

public abstract class BatchProcessor {
    public void batchProcess(File file) {
        openFile(file);
        List<Record> records = null;
        Parser parser = createParser(file);
        records = parser.parse();
        processRecords(records);
        closeFile(file);
    }

    public abstract Parser createParser(File file); // factory method

    private void openFile(File file) {
        System.out.println("Opening file : " + file.getName());
    }

    private void processRecords(List<Record> records) {
        System.out.println("Processing text records ...");
        System.out.println("0 failures while processing file...");
        System.out.println("Batch Processing Completed for this file");
    }

    private void closeFile(File file) {
        System.out.println("closing this file");
    }
}
