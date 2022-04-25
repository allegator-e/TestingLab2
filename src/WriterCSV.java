import util.FunctionSystem;
import util.Point;

import java.util.ArrayList;

public class WriterCSV {

    public static void main(String[] args) {
	    FunctionSystem fs = new FunctionSystem();
	    PrinterCSV printer = new PrinterCSV();
		ArrayList<Point> points;
		points = fs.getPoints(fs.getCos(), -Math.PI, Math.PI, 0.0001, 200);
		printer.printTo("cos.csv", points);
		points = fs.getPoints(fs.getSin(), -Math.PI, Math.PI, 0.0001, 200);
		printer.printTo("sin.csv", points);
		points = fs.getPoints(fs.getLn(), 0, Math.PI, 0.0001, 200);
		printer.printTo("ln.csv", points);
		points = fs.getPoints(fs.getLog2(), 0, Math.PI, 0.0001, 200);
		printer.printTo("log2.csv", points);
		points = fs.getPoints(fs.getLog3(), 0, Math.PI, 0.0001, 200);
		printer.printTo("log3.csv", points);
		points = fs.getPoints(fs.getLog5(), 0, Math.PI, 0.0001, 200);
		printer.printTo("log5.csv", points);
		points = fs.getPoints(fs.getLog10(), 0, Math.PI, 0.0001, 200);
		printer.printTo("log10.csv", points);
		points = fs.getPoints(fs.getOurFunc(), -10, 10, 0.0001, 200);
		printer.printTo("our_func.csv", points);
    }
}
