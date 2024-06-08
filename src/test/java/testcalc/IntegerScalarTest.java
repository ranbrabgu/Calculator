package testcalc;

import calculator.IntegerScalar;
import calculator.RationalScalar;
import calculator.Scalar;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class IntegerScalarTest {

    @Test
    public void toStringTest() {
        Scalar s = new IntegerScalar(3);
        assertEquals("3", s.toString());
    }

    @Test
    public void addRationalTest() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new RationalScalar(1, 2);
        Scalar s3 = s1.add(s2);

        RationalScalar res = new RationalScalar(7, 2);
        assertEquals(res, s3);
    }

}
