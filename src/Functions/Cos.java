package Functions;

import util.FunctionSystem;

public class Cos extends Func implements Calculation{
    Sin sin;

    public Cos() {
        sin = new Sin();
    }

    public Cos(Sin sin) {
        this.sin = sin;
    }

    private final Double pi2 = 2*Math.PI;
    private final Double piNa2 = Math.PI/2;
    private final Double pi3Na2 = 3*Math.PI/2;

    @Override
    public Double calc(Double x, Double precision) {
        double y = Math.sqrt(1 - Math.pow(sin.calc(x, precision), 2));
        return Math.abs(x) % pi2 <=  piNa2 || Math.abs(x) % pi2 >= pi3Na2 ? y : -y;
    }
}
