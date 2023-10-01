package Ch12.Ch12DevEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MailMerge {
    public static void main(String[] args) {
        String templateFileName = "files/template.txt";
        String dataFileName = "files/data.txt";
        String outputFileName = "files/output2.txt";

        try {
            BufferedReader templateReader = new BufferedReader(new FileReader(templateFileName));
            BufferedReader dataReader = new BufferedReader(new FileReader(dataFileName));
            FileWriter writer = new FileWriter(outputFileName);

            String templateLine;
            while ((templateLine = templateReader.readLine()) != null) {
                String dataLine = dataReader.readLine();
                if (dataLine == null) {
                    break; // Stop if there's no more data
                }

                String[] dataParts = dataLine.split(",");
                String name = dataParts[0];
                String age = dataParts[1];
                String gender = dataParts[2];

                String mergedLine = templateLine
                        .replace("<<N>>", name)
                        .replace("<<A>>", age)
                        .replace("<<G>>", gender);

                writer.write(mergedLine + "\n");
            }

            templateReader.close();
            dataReader.close();
            writer.close();

            System.out.println("Letters merged and saved to " + outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
