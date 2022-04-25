package Functions;

public class Sin extends Func implements Calculation {
    @Override
    public Double calc(Double x,Double precision) {
        if (Double.isFinite(x)) {
            double previousValue = x;
            double factorial = 2 * 3;
            double currentValue = x - Math.pow(x, 3) / factorial;
            for (int i = 2; Math.abs(currentValue - previousValue) > precision; i++) {
                previousValue = currentValue;
                double xPower = 2 * i + 1;
                factorial = xPower * (xPower - 1) * factorial;
                currentValue += Math.pow(-1, i) * Math.pow(x, xPower) / factorial;
            }
            return currentValue;
        } else
            return Double.NaN;

    }
}