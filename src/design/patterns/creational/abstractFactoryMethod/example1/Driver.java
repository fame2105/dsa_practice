package design.patterns.creational.abstractFactoryMethod.example1;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        String completeFileName = args[0];
        File file = new File(completeFileName);
        String fileType = args[1];
        BatchProcessor batchProcessor = createBatchProcessor(file, fileType); // SimpleFactory
        batchProcessor.batchProcess(file);
    }

    private static BatchProcessor createBatchProcessor(File file, String fileType) {
        if(fileType.equalsIgnoreCase("txt")) {
            return new TextBatchProcessor(file);
        } else if(fileType.equalsIgnoreCase("csv")) {
            return new CSVBatchProcessor(file);
        } else {
            return new PDFBatchProcessor(file);
        }
    }
}
