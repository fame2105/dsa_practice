package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
             reader = new BufferedReader(new FileReader("C:\\dev\\personal_projects\\daily-coding\\src\\utility\\sample.txt"));
             String line = reader.readLine();
             while(line != null) {
                 String str1 = "https://jira.dev.smbc.nasdaqomx.com/jira/projects/";
                 String str2 = "?selectedItem=com.atlassian.jira.jira-projects-plugin%3Arelease-page&status=unreleased";
                 System.out.println(str1 + line + str2);
                 line = reader.readLine();
             }
             reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
