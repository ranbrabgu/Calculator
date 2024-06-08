package calculator;

public class testing {
    public static void main(String[] args) {
        System.out.println("in main");
        Polynomial p1 = Polynomial.build("1 5 2/3 8 4/3 4/3 28 1/1 4/4");

        
        System.out.println(p1);
        System.out.println("+1 +5x +2/3^2 +8x^3 +4/3x^4 +4/3x^5 +28x^6 +x^7 +x^8");
        
        // ---evaluating valuse---
        // [1,5,2/3,8,4/3,4/3,28,1/1,4/4]
        // ---Monomials---
        // 1: int+ ^ int
        // 2: int- ^ int
        // 3: int+ ^ 0
        // 4: int- ^ 0 
        // 5: rational+ ^ int a
        // 6: rational+ ^ int b
        // 7: rational- ^ int a
        // 8: rational- ^ int b
        // 9: rational+ ^ 0
        // 10: rational- ^ 0

        //---cheacks--
        // n + n
        // n * n
        //  
        // for each output:
        //      sign()
        //
        //
        //---Polynomials---
        // create 10 comibations with monomials
        // n + n
        // n * n
        // 
        //  for each: 
        //      deriveative
        //      evaluate
        //  
          
        
        






    }
    
}
