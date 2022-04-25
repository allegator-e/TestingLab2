package Functions;

public class Log extends Func implements Calculation {
    Double base;
    Ln ln;

    public Log(Double base) {
        this.base = base;
        ln = new Ln();
    }

    public Log(Double base, Ln ln) {
        this.base = base;
        this.ln = ln;
    }

    @Override
    public Double calc(Double x, Double precision) {
        if (x > 0 && base > 0 && Double.isFinite(x) && Double.isFinite(base)) {
            return ln.calc(x, precision)/ ln.calc(base, precision);
        } else
            return Double.NaN;
    }
}
