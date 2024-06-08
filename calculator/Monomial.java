package calculator;

public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(Scalar coefficient, int exponent){
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    public int getExponent(){
        return this.exponent;
    }
    public Scalar getCoefficient(){
        return this.coefficient;
    }

    public Monomial add(Monomial m){
        if(this.getExponent() != m.getExponent()){return null;}
        return new Monomial(getCoefficient().add(m.getCoefficient()), getExponent());
    }
    public Monomial mul(Monomial m){
        return new Monomial(getCoefficient().mul(m.getCoefficient()), getExponent()*m.getExponent());
    }

    public Scalar evaluate(Scalar s){
        return (s.power(getExponent())).mul(getCoefficient());
    }
    public Monomial derivative(){
        return new Monomial(getCoefficient().mul(new IntegerScalar(getExponent())), getExponent()-1);
    }
    
    public int sign(){
        return getCoefficient().sign();
    }

    public boolean equals(Object o){
        if(!(o instanceof Monomial)){
            return false;
        }
        return  getCoefficient().equals(((Monomial)o).getCoefficient()) && getExponent() == ((Monomial)o).getExponent();
    }

    public String toString(){
        if(this.coefficient.equals(new IntegerScalar(0))) return "0";
        if(this.exponent == 0)return "1";
        String res = "x";
        if(!(this.coefficient.equals(new IntegerScalar(1))))res = this.coefficient.toString() + res;
        if(this.exponent != 1)res = res +"^"+ exponent;
        return res;
    }
}
