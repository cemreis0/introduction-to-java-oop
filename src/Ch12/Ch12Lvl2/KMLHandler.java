/*
 * Converting data in one format to another format is a very common programming task.
 * In this exercise, you will input longitude and latitude information
 * from a text file and output the data in KML (Keyhole Markup Language)
 * format. KML is a file format used in Google Earth and Google Maps to
 * record geometric annotation and visualization information. Complete information
 * on KML can be found at http://earth.google.com/kml
 * An input file is a text file that contains a sequence of longitude and latitude
 * data in the following format:
 * -121.87 36.61
 * -3.02 16.77
 * 34.75 139.76
 * ...
 * Longitude and latitude data are separated by a blank space. The output
 * file is also a text file with information saved in KML format. Here’s an
 * example:
 * <?xml version="1.0" encoding="UTF-8"?>
 * <kml xmlns="http://earth.google.com/kml/2.1">
 *     <Document>
 *         <name>Mystery Locations</name>
 *         <Placemark>
 *             <name>Location 1</name>
 *             <Point>
 *                 <coordinates>-121.87,36.61,0</coordinates>
 *             </Point>
 *         </Placemark>
 *         <Placemark>
 *             <name>Location 2</name>
 *             <Point>
 *                 <coordinates>-3.02,16.77,0</coordinates>
 *             </Point>
 *         </Placemark>
 *     </Document>
 * </kml>
 * The top and the bottom portions
 * <?xml version="1.0" encoding="UTF-8"?>
 * <kml xmlns="http://earth.google.com/kml/2.1">
 *     <Document>
 *         <name>Mystery Locations</name>
 *         ...
 *     </Document>
 * </kml>
 * are the same for all output files. For each longitude and latitude pair, you
 * generate the corresponding <Placemark> section. For example, if the data
 * values are -3.02 and 16.67 for the second longitude/latitude pair, you
 * generate
 * <Placemark>
 *     <name>Location 2</name>
 *     <Point>
 *         <coordinates>-3.02,16.77,0</coordinates>
 *     </Point>
 * </Placemark>
 * The values that are dependent on the input data are shown in red bold text
 * for illustration purpose (it’s a text file, so in the actual output, there’s no such
 * color output). Notice that there is always the output of 0 as the third value in
 * the <coordinates> section. Indentation in the output file can be achieved by
 * outputting the tab (\t) characters. Use JFileChooser to allow the user to
 * specify the input and output files. Create your own test input files using a
 * text editor. In addition to or in lieu of checking the correctness of your output
 * files manually, you can use Google Earth. Open your output file from Google Earth.
 * If your output KML file is correct, Google Earth will display a pushpin for each
 * location (placemark) in the file. Google Earth is available for download from
 * http://earth.google.com/download-earth.html
 */

/*

*/

package Ch12.Ch12Lvl2;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class KMLHandler {
    public static void main(String[] args) throws IOException {
        // file selection
        JFileChooser fileChooser = new JFileChooser("files");
        int status = fileChooser.showDialog(null, "Get Coordinates!");

        // String templates
        String template = """
            <Placemark>
                <name>Location %d</name>
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
        }
    }
}
