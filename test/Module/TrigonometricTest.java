package Module;

import Functions.Cos;
import Functions.Sin;

import static java.lang.Math.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometricTest {
    Sin sin = new Sin();
    Cos cos = new Cos();

    @ParameterizedTest
    @ValueSource(doubles = {-PI, -PI/2, -0.5, 0, 1.1, PI/2, PI})
    public void sinTest(double x) {
        assertEquals(sin.calc(x, 0.00001), Math.sin(x), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-PI, -PI/2, -0.5, 0, 1.1, PI/2, PI})
    public void cosTest(double x) {
        assertEquals(cos.calc(x, 0.00001), Math.cos(x), 0.001);
    }
}
