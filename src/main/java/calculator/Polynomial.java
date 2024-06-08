package calculator;

import java.util.ArrayList;
import java.util.List;

public class Polynomial{

    private List<Monomial> monomials;


    public Polynomial(){ 
        this.monomials = new ArrayList<>();
    }


    public static Polynomial build(String input){
        Polynomial poly = new Polynomial();
        int exponent = 0;
        String[] coeffs = input.split("\\s+");
        for(String coeff : coeffs){
            poly.monomials.add(new Monomial(ParseScalar(coeff), exponent));
            exponent++;
        }
        return poly;
    }

    private static Scalar ParseScalar(String num){
        if(num.contains("/")){
             String[] ratio = num.split("/");
            return new RationalScalar(Integer.parseInt(ratio[0]), Integer.parseInt(ratio[1]));
        }
        return new IntegerScalar(Integer.parseInt(num));
    }


    public Polynomial add(Polynomial p){
        Polynomial result= new Polynomial();
        for(int i=0; i<= monomials.size(); i++){
            Scalar coeff= (this.monomials.get(i).getCoefficient()).add(p.monomials.get(i).getCoefficient());
            result.monomials.add(new Monomial(coeff, i));
        }
        return result;
    }


    public Polynomial mul(Polynomial p){
        Polynomial result= new Polynomial();
        for (Monomial m1 : this.monomials) {
            for (Monomial m2 : p.monomials) {
                Scalar coeff = m1.getCoefficient().mul(m2.getCoefficient());
                Polynomial adding = new Polynomial();
                adding.monomials.add(new Monomial(coeff, m1.getExponent()+m2.getExponent()));
                result.add(adding);
            }
        }
        return result;
    }


    public Scalar evaluate(Scalar s){
        Scalar res= new IntegerScalar(0);
        for(Monomial m : this.monomials){
            res.add(m.getCoefficient().mul((s.power(m.getExponent()))));
        }
        return res;
    }


    public Polynomial derivative(Polynomial p){
        Polynomial res= new Polynomial();
        for (Monomial m : p.monomials) {
            res.monomials.add(m.derivative());
        }
        return res;
    }


    public boolean equals(Object o){
        if(!(o instanceof Polynomial)){
            return false;
        }
        return monomials.equals(((Polynomial)o).monomials);
    }


    public String toString(){
        String res= "";
        for(Monomial m : this.monomials){
            res= res + m.toString();
        }
        return res;
    }
}