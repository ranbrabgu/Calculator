package calculator;

public class IntegerScalar  implements Scalar{

    private int number;

    public IntegerScalar(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    @Override
    public Scalar add(Scalar s){
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(IntegerScalar other){
        return new IntegerScalar(getNumber() + other.getNumber());
    }
    
    @Override
    public Scalar addRational(RationalScalar other){
        return (new RationalScalar((getNumber() * other.getDenominator()) + other.getNumerator(), other.getDenominator())).reduce();
    }

    @Override
    public Scalar mul(Scalar s){
        return s.mulInteger(this);
    }

    @Override
    public Scalar mulInteger(IntegerScalar other){
        return new IntegerScalar(getNumber() * other.getNumber());
    }
     
    @Override
    public Scalar mulRational(RationalScalar other){
        return (new RationalScalar(getNumber() * other.getNumerator(),other.getDenominator())).reduce();
    }

 
    @Override
    public Scalar neg(){
        return new IntegerScalar(-1*getNumber());
    }

    @Override
    public Scalar power(int exponent){
        return new IntegerScalar((int)Math.pow(getNumber(), exponent));
    }
    
    @Override
    public int sign(){
        return java.lang.Integer.compare(getNumber(), 0);
    }
 
    @Override
    public boolean equals(Object o){
        if(o instanceof IntegerScalar){
            return ((IntegerScalar)o).getNumber() == this.getNumber();
        }
        if(o instanceof RationalScalar){
            RationalScalar rationalO = (((RationalScalar)o).reduce());
            return rationalO.getNumerator() == this.getNumber() && rationalO.getDenominator() == 1;
        }
        return false;
        
    }

    public String toString(){
        return ""+this.getNumber();
    }
}
