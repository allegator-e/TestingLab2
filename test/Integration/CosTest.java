package Integration;

import Functions.Cos;
import Functions.Sin;
import static java.lang.Math.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CosTest {

    @Mock
    Sin sinMock;

    @Test
    public void testCosIntegration() {
        when(sinMock.calc(PI/2, 0.001)).thenReturn(1D);
        Cos cos = new Cos(sinMock);
        assert(cos.calc(PI/2, 0.001).equals(0.0));
    }
}
