package testcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import calculator.IntegerScalar;
import calculator.Monomial;
import calculator.RationalScalar;
import calculator.Scalar;

class MonomialTest {


    @Test
    public void MonomialGetTest() {
        Monomial m = new Monomial(new IntegerScalar(4), 3);
        assertEquals(new IntegerScalar(4), m.getCoefficient());
        assertEquals(3, m.getExponent());
    }
    @Test
    public void MonomialAddTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 3); 
        Monomial m3 = new Monomial(new RationalScalar(5, 2), 2); 
        assertEquals(new RationalScalar(9,2), m1.add(m2).getCoefficient());
        assertEquals(3, m1.add(m2).getExponent());
        assertEquals(null, m1.add(m3));
        assertEquals(null, m1.add(m3));
    }

    @Test
    public void MonomialMulTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 2); 
        assertEquals(new RationalScalar(4,2), m1.mul(m2).getCoefficient());
        assertEquals(5, m1.mul(m2).getExponent());
    }

    @Test
    public void MonomialEvaluateTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 2);

        Scalar s1 = new IntegerScalar(2);
        Scalar s2 = new RationalScalar(1, 2);
        Scalar s3 = new IntegerScalar(-10);
        Scalar s4 = new RationalScalar(-5, 7);

        assertEquals(new IntegerScalar(32), m1.evaluate(s1));
        assertEquals(new RationalScalar(1,2), m1.evaluate(s2));
        assertEquals(new IntegerScalar(-4000), m1.evaluate(s3));
        assertEquals(new RationalScalar(-500,343), m1.evaluate(s4));

        assertEquals(new RationalScalar(2,1), m2.evaluate(s1));
        assertEquals(new RationalScalar(1,8), m2.evaluate(s2));
        assertEquals(new IntegerScalar(50), m2.evaluate(s3));
        assertEquals(new RationalScalar(25,98), m2.evaluate(s4));
    }

    @Test
    public void MonomialDeriviativeTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 2);
        assertEquals(new Monomial(new IntegerScalar(12), 2), m1.derivative());
        assertEquals(new Monomial(new RationalScalar(1, 1), 1), m2.derivative());
    }

    @Test
    public void MonomialSignTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 2);
        Monomial m3 = new Monomial(new IntegerScalar(-4), 3);
        Monomial m4 = new Monomial(new RationalScalar(-1, 2), 2);
        assertEquals(1, m1.sign());
        assertEquals(1, m2.sign());
        assertEquals(-1, m3.sign());
        assertEquals(-1, m4.sign());
    }
    @Test
    public void MonomialEqualsTest() {
        Monomial m1 = new Monomial(new IntegerScalar(4), 3);
        Monomial m2 = new Monomial(new RationalScalar(1, 2), 2);
        Monomial m3 = new Monomial(new IntegerScalar(4), 3);
        Monomial m4 = new Monomial(new RationalScalar(1, 2), 2);
        assertEquals(false, m1.equals(m2));
        assertEquals(false, m1.equals(m4));
        assertEquals(true, m1.equals(m3));
        assertEquals(true, m2.equals(m4));
    }

    @Test
    public void MonomialToStringTest() {
        Monomial m = new Monomial(new IntegerScalar(4), 3);
        assertEquals("4x^3", m.toString());
    }
}