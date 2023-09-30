/*
Extend Exercise 20 by processing information in the LINK tags. One of the
information contained in the LINK tag is the href attribute that refers to a
linked Web page, such as
<LINK href="http:www.somewhere.com/info.html"/>
Extend the program from Exercise 20 by extracting and displaying the Web
addresses of the referenced pages. For the sample tag, you display the Web
address
http:www.somewhere.com/info.html
The format for the href attribute is the text href (case-insensitive) followed
immediately by the equal symbol =. The Web address is surrounded by the
double quotes.
*/


package Ch12.Ch12Lvl2;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KMLHandlerVer2 {
    public static void main(String[] args) throws IOException {
        // file selection
        JFileChooser fileChooser = new JFileChooser("files");
        int status = fileChooser.showDialog(null, "Get Coordinates!");

        // String templates
        String template = """
            <Placemark>
                <name>Location %d</name>
                <LINK href="http://www.somewhere.com/info.html"/>
                <Point>
                    <coordinates>%.2f,%.2f,0</coordinates>
                </Point>
            </Placemark>
        """;
        String top = """
        <?xml version="1.0" encoding="UTF-8"?>
        <kml xmlns="http://earth.google.com/kml/2.1">
        <Document>
            <name>Mystery Locations</name>
        """;
        String bottom = """
        </Document>
        </kml>
        """;

        StringBuilder resultBuilder;
        String result;
        int count = 1;

        // declare the streams to read coordinates
        File file;
        FileReader fileReader;
        Scanner scanner;

        if (status == JFileChooser.APPROVE_OPTION) {
            // create the streams if the file is chosen
            file = fileChooser.getSelectedFile();
            fileReader = new FileReader(file);
            scanner = new Scanner(fileReader);

            String line;
            resultBuilder = new StringBuilder();
            resultBuilder.append(top);
            while (scanner.hasNextLine()) {
                // get the new line from the file and split it into two, namely longitude and latitude
                line = scanner.nextLine();
                String[] parts = line.split(" ");

                double longitude = Double.parseDouble(parts[0]);
                double latitude = Double.parseDouble(parts[1]);

                // Generate KML markup and write it to the output file
                resultBuilder.append(String.format(template, count, longitude, latitude));

                count++;
            }

            resultBuilder.append(bottom);

            result = resultBuilder.toString();
            System.out.println(result);

            // get the link
            // Define a regular expression pattern to match LINK tags
            String pattern = "<LINK\\s+href=\"(http[^\"]+)\"[^>]*>";

            // Compile the pattern
            Pattern linkPattern = Pattern.compile(pattern);

            // Create a Matcher to find matches in the HTML content
            Matcher matcher = linkPattern.matcher(result);

            // Find and display the URLs
            // get the file and streams to write the links
            File linkFile;
            FileOutputStream outputStream;
            PrintWriter printWriter;

            // choose file
            int statusLink = fileChooser.showDialog(null, "Save links to this file!");
            if (statusLink == JFileChooser.APPROVE_OPTION) {
                linkFile = fileChooser.getSelectedFile();
                outputStream = new FileOutputStream(linkFile);
                printWriter = new PrintWriter(outputStream);
                while (matcher.find()) {
                    String href = matcher.group(1);

                    printWriter.write(href);
                    printWriter.write(System.getProperty("line.separator"));
                }
                printWriter.close();
            }
        }
    }
}
