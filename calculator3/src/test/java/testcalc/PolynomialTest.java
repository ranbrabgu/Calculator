package testcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import calculator.IntegerScalar;
import calculator.Polynomial;
import calculator.RationalScalar;
import calculator.Scalar;

class PolynomialTest {

    @Test
    public void PolynomialToStringBuildTest() {
        Polynomial p1 = Polynomial.build("1 5 2/3 8 4/3 4/3 28 1/1 4/4");
        assertEquals("+1 +5x +2/3^2 +8x^3 +4/3x^4 +4/3x^5 +28x^6 +x^7 +x^8", p1.toString());
    }
    @Test
    public void PolynomialAddTest() {
        Polynomial p1 = Polynomial.build("1 5 2/3 8 4 4/3 28 1/1 4/4");
        Polynomial p2 = Polynomial.build("4 1 0 8 1/3 4/3 2 ");
        Polynomial p3 = Polynomial.build("5 6 2/3 16 13/3 8/3 30 1 1");
        assertEquals(p3, p1.add(p2));
    }
    @Test
    public void PolynomialMulTest(){
        Polynomial p1 = Polynomial.build("1 5 2/3 8 4 4/3 28 1/1 4/4");
        Polynomial p2 = Polynomial.build("4 1 0 -8 1/3 4/3 2 ");
        Polynomial p3 = Polynomial.build("4 21 23/3 74/3 -47/3 7 594/9");
        assertEquals(p3, p1.mul(p2));
    }
    @Test
    public void PolynomialEvaluateTest(){
        Polynomial p = Polynomial.build("1 5 2/3 8 4 4/3");

        Scalar s1 = new IntegerScalar(2);
        Scalar s2 = new RationalScalar(1, 2);
        Scalar s3 = new IntegerScalar(-10);
        Scalar s4 = new RationalScalar(-5, 2);

        assertEquals(new RationalScalar(553,3), p.evaluate(s1));
        assertEquals(new IntegerScalar(5), p.evaluate(s2));
        assertEquals(new RationalScalar(10253,3), p.evaluate(s3));
        assertEquals(new RationalScalar(-539,24), p.evaluate(s4));
    }
    @Test
    public void PolynomialDerivativeTest(){
        Polynomial p1 = Polynomial.build("1 5 2/3 8 4 4/3");
        Polynomial p2 = Polynomial.build("5 4/3 24 16 20/3");
        assertEquals(p2, p1.derivative());
    }


}