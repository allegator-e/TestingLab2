package Functions;

public class OurFunc extends Func implements Calculation{
    Cos cos;
    Log log2;
    Log log3;
    Log log5;
    Log log10;

    public OurFunc() {
        cos = new Cos();
        log2 = new Log(2.0);
        log3 = new Log(3.0);
        log5 = new Log(5.0);
        log10 = new Log(10.0);
    }

    public OurFunc(Cos cos, Log log2, Log log3, Log log5, Log log10) {
        this.cos = cos;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }
    
    @Override
    public Double calc(Double x, Double precition) {
        if (x <= 0)
        return cos.calc(x, precition);
        return ((((    Math.pow(log5.calc(x, precition), 3)
                - log2.calc(x, precition))
                * log5.calc(x, precition))
                + log5.calc(x, precition))
                / ((log10.calc(x, precition)
                - (log10.calc(x, precition)
                * log3.calc(x, precition)))
                / log2.calc(x, precition)));
    }
}
