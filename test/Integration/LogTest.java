package Integration;

import Functions.Ln;
import Functions.Log;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static java.lang.Math.PI;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogTest {
    @Mock
    Ln lnMock;

    @Test
    public void testLog2Integration() {
        when(lnMock.calc(2D, 0.001)).thenReturn(0.693147);

        Log log2 = new Log(2D, lnMock);
        assert(log2.calc(2D, 0.001).equals(1.0));
    }

    @Test
    public void testLog5Integration() {
        when(lnMock.calc(any(Double.class), eq(0.001))).thenReturn(1.60943, 0.693147);
        Log log5 = new Log(5D, lnMock);
        assertEquals(log5.calc(2D, 0.001), 2.32191, 0.00001);
    }
}
