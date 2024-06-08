package calculator;

public class RationalScalar implements Scalar{
    private int numerator;
    private int denominator;

    public RationalScalar(int numerator, int denominator){
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public  int getDenominator(){return this.denominator;}
    public int getNumerator(){return this.numerator;}

    @Override
    public Scalar add(Scalar other){
        return other.addRational(this);
    }

    public Scalar addInteger(IntegerScalar other){
        int newNum = this.numerator + (other.getNumber() * this.denominator);
        return new RationalScalar(newNum, this.denominator);
        
    }

    public Scalar addRational(RationalScalar s){
        int newNum = (this.numerator * s.denominator) + (s.numerator * this.denominator);
        int newDen = this.denominator * s.denominator;
        return (new RationalScalar(newNum, newDen)).reduce();
    }
    @Override
    public Scalar mul(Scalar s){
        return s.mulRational(this);
    }

    public Scalar mulInteger(IntegerScalar other){
        return new RationalScalar(this.getNumerator()*other.getNumber(), this.getDenominator());
    }
    public Scalar mulRational(RationalScalar other){
        return new RationalScalar(this.getNumerator()*other.getNumerator(), this.getDenominator()*other.getDenominator());
    }

    @Override
    public Scalar neg(){
        return new RationalScalar(-1*getNumerator(), getDenominator());
    }

    @Override
    public Scalar power(int exponent){
        int newNum = (int)Math.pow(getNumerator(), exponent);
        int newDen = (int)Math.pow(getDenominator(), exponent);
        return new RationalScalar(newNum, newDen);
    }

    @Override
    public int sign(){
        int NumSign = java.lang.Integer.compare(getNumerator(), 0);
        int DenSign = java.lang.Integer.compare(getNumerator(), 0);

        return NumSign*DenSign;
    }

    public RationalScalar reduce(){
        int num = getNumerator();
        int den = getDenominator();

        int gcd = getGCD(num,  den);
        if(den<0){den = den*-1; num = num*-1;}

        return new RationalScalar(num/gcd, den/gcd);
    } 

    private int getGCD(int a, int b){
        if(a<0){a = -1*a;}
        if(b<0){b = -1*b;}

        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof IntegerScalar){
            RationalScalar reducedThis = this.reduce();
            return  reducedThis.getNumerator() == ((IntegerScalar)o).getNumber() && reducedThis.getDenominator() == 1;
 
        }
        if(o instanceof RationalScalar){
            RationalScalar reducedThis = this.reduce();
            RationalScalar reducedO = ((RationalScalar) o).reduce();
            return  reducedThis.getNumerator() == reducedO.getNumerator() && reducedThis.getDenominator() == reducedO.getDenominator();
        }
        return false;
    }

    public String toString(){
        return getNumerator() + " / " + getDenominator();
    }

}
