package calculator;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar addInteger(IntegerScalar other);
    Scalar addRational(RationalScalar other);



    Scalar mul(Scalar s);
    Scalar mulInteger(IntegerScalar other);
    Scalar mulRational(RationalScalar other);

     
    Scalar neg();
    
    Scalar power(int exponent);

    int sign();

    public boolean equals(Object o);
    
}
