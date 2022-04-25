import util.Point;

import java.io.*;
import java.util.ArrayList;

public class PrinterCSV {

    public void printTo(String filename, ArrayList<Point> points) {

        try (PrintStream printStream = new PrintStream(new FileOutputStream(filename, true))) {
            points.forEach(printStream::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
