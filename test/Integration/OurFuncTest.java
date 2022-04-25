package Integration;

import Functions.Cos;
import Functions.Log;
import Functions.OurFunc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OurFuncTest {

    @Mock
    private Cos cosMock;
    @Mock
    private Log log2Mock;
    @Mock
    private Log log3Mock;
    @Mock
    private Log log5Mock;
    @Mock
    private Log log10Mock;

    private OurFunc ourFunc;

    @BeforeEach
    void setOurFunc() {
        ourFunc = new OurFunc(cosMock, log2Mock, log3Mock, log5Mock, log10Mock);
    }

    @Test
    public void testOurFuncIntegration() {
        ourFunc = new OurFunc(cosMock, log2Mock, log3Mock, log5Mock, log10Mock);
        when(cosMock.calc(-1.0, 0.0001)).thenReturn(0.540302);
        assertEquals(ourFunc.calc(-1.0, 0.0001), 0.540302, 0.0001);
    }

    @Test
    public void testOurFuncIntegrationBorder() {
        when(cosMock.calc(0D, 0.0001)).thenReturn(0D);
        assertEquals(ourFunc.calc(0D, 0.0001), 0D, 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "0.2, -2.3219280909047058, -1.4649735170265141, -1.0, -0.6989700065442305, -3.1291525319066475",
            "1.1800000000000002, 0.23878685987813644, 0.1506577345378039, 0.1028399031018642, 0.07188200774411804, 0.30661649301591754",
            "2.16, 1.1110313130800484, 0.7009827120077959, 0.47849514264981013, 0.3344537529893203, -0.007847303476472174",
            "1.0, 0.0, 0.0, 0.0, 0.0, NaN",
            "3.0, 1.5849625019963292, 1.0, 0.6826061962060037, 0.47712125742924266, -Infinity",
            "3.14, 1.6507645589234796, 1.0415164755281403, 0.7109455996461472, 0.49692965043725934, 16.577837993092963",
            "4.12, 2.0426443366281646, 1.288765086906072, 0.8797190337760536, 0.6148972187955323, 3.661743706748601",
            "5.1000000000000005, 2.350497240085912, 1.4829986432646567, 1.0123040628575515, 0.7075701774402938, 2.1801110284765266",
            "6.080000000000001, 2.6040713174073455, 1.6429860732524617, 1.1215124738823015, 0.7839035812089483, 1.1208507204742932",
            "7.060000000000001, 2.8196681778863053, 1.7790125471957923, 1.2143649878440734, 0.8488047035004563, 0.14947740027947923",
            "8.040000000000001, 3.007195489760596, 1.8973291077693655, 1.2951286052053774, 0.9052560496560227, -0.7920611385871362",
            "9.020000000000001, 3.1731274144760637, 2.002020496055504, 1.3665915955389043, 0.9552065364771183, -1.7174537842169557"
    })
    public void testOurFuncIntegration2(double x, double expectedLog2, double expectedLog3, double expectedLog5, double expectedLog10, double y) {
        when(log2Mock.calc(x, 0.0001)).thenReturn(expectedLog2);
        when(log3Mock.calc(x, 0.0001)).thenReturn(expectedLog3);
        when(log5Mock.calc(x, 0.0001)).thenReturn(expectedLog5);
        when(log10Mock.calc(x, 0.0001)).thenReturn(expectedLog10);
        assertEquals(ourFunc.calc(x, 0.0001), y, 0.0001);
    }
}
