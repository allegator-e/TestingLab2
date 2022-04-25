package util;

import Functions.*;

import java.util.ArrayList;


public class FunctionSystem {

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);

    private final Ln ln = new Ln();
    private final Log log2 = new Log(2.0, ln);
    private final Log log3 = new Log(3.0, ln);
    private final Log log5 = new Log(5.0, ln);
    private final Log log10 = new Log(10.0, ln);
    private final OurFunc ourFunc = new OurFunc(cos, log2, log3, log5, log10);

    public ArrayList<Point> getPoints(Func func, double fromX, double toX, double perc, int stepCount) {
        ArrayList<Point> points = new ArrayList<>();
        double step = (toX - fromX)/stepCount;
        double y;
        for (double x = fromX; x <= toX; x+= step) {
            y = func.calc(x, perc);
            points.add(new Point(x, y));
        }
        return points;
    }

    public Cos getCos() {
        return cos;
    }

    public Sin getSin() {
        return sin;
    }

    public Ln getLn() {
        return ln;
    }

    public Log getLog2() {
        return log2;
    }

    public Log getLog3() {
        return log3;
    }

    public Log getLog5() {
        return log5;
    }

    public Log getLog10() {
        return log10;
    }

    public OurFunc getOurFunc() {
        return ourFunc;
    }
}
