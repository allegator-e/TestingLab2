package Module;

import Functions.Cos;
import Functions.Ln;
import Functions.Log;
import Functions.Sin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogarifmicTest {
    Ln ln = new Ln();
    Log log5 = new Log(5D);
    Log log05 = new Log(0.5D);

    @ParameterizedTest
    @ValueSource(doubles = {-5, 0.5, 1, 2})
    public void lnTest(double x) {
        assertEquals(ln.calc(x, 0.00001), Math.log(x), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-5, 0.5, 1, 2})
    public void setLog5Test(double x) {
        assertEquals(log5.calc(x, 0.00001), Math.log(x)/Math.log(5), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-5, 0.5, 1, 2})
    public void setLog05Test(double x) {
        assertEquals(log05.calc(x, 0.00001), Math.log(x)/Math.log(0.5), 0.001);
    }
}
