package testcalc;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import calculator.IntegerScalar;
import calculator.RationalScalar;
import calculator.Scalar;

class IntegerScalarTest {

    @Test
    public void getNumberTest() {
        IntegerScalar s = new IntegerScalar(3);
        assertEquals(3, s.getNumber());
    }

    @Test
    public void IntegerToStringTest() {
        Scalar s = new IntegerScalar(3);
        assertEquals("3", s.toString());
    }

    @Test
    public void IntegerAddRationalTest() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new RationalScalar(1, 2);
       
        assertEquals(new RationalScalar(7, 2), s1.add(s2));
    }
    @Test
    public void IntegeraAddIntegerTest() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(2);
        Scalar s3 = new IntegerScalar(0);
        assertEquals(new IntegerScalar(5), s1.add(s2));
        assertEquals(new IntegerScalar(3), s1.add(s3));
    }

    @Test
    public void IntegerMulIntegerTest() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(2);
        Scalar s3 = new IntegerScalar(0);
        assertEquals(new IntegerScalar(6), s1.mul(s2));
        assertEquals(new IntegerScalar(0), s1.mul(s3));
    }

    @Test
    public void IntegerMulRationalTest() {
        Scalar s1 = new IntegerScalar(3);
        Scalar s2 = new RationalScalar(1, 2);
        Scalar s3 = new RationalScalar(0, 2);
        assertEquals(new RationalScalar(3, 2), s1.mul(s2));
        assertEquals(new RationalScalar(0, 2), s1.mul(s3));
    }

    @Test
    public void IntegerNegTest() {
        Scalar s = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(0);
        assertEquals(new IntegerScalar(-3), s.neg());
        assertEquals(new IntegerScalar(0), s2.neg());
    }
    @Test
    public void IntegerPowerTest() {
        Scalar s = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(0);
        assertEquals(new IntegerScalar(9), s.power(2));
        assertEquals(new IntegerScalar(0), s2.power(2));
    }
    @Test
    public void IntegerSignTest() {
        Scalar s = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(0);
        Scalar s3 = new IntegerScalar(-3);
        assertEquals(1, s.sign());
        assertEquals(0, s2.sign());
        assertEquals(-1, s3.sign());
    }
    @Test
    public void IntegerEqualsTest() {
        Scalar s = new IntegerScalar(3);
        Scalar s2 = new IntegerScalar(3);
        Scalar s3 = new IntegerScalar(4);
        assertEquals(true, s.equals(s2));
        assertEquals(false, s.equals(s3));
    }
  
}