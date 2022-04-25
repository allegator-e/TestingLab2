package Functions;

public class Ln extends Func implements Calculation {
    int DEFAULT_MAX_ITERATIONS = 1_000_000;

    @Override
    public Double calc(Double x,Double precision) {

        if (x == 1)
            return 0.0;

        boolean little = false;
        if (x < 1) {
            x = Math.pow(x, -1);
            little = true;
        }

        x = (x - 1) / (x + 1);
        if (x > 0 && Double.isFinite(x)) {
            double previousResult = 0;
            double result = 2 * x;

            int i = 1;
            while (i < DEFAULT_MAX_ITERATIONS && Math.abs(result - previousResult) > precision * precision && Double.isFinite(result)) {
                previousResult = result;
                result += 2 * Math.pow(x, 2 * i + 1) / (2 * i + 1);
                i++;
            }
            if (little) {
                return -result;
            }
            return result;
        } else
            return Double.NaN;
    }
}
