import java.util.InputMismatchException;

public class Fraction {
    private int num;
    private int denom;

    public Fraction(int num, int denom){
        // error when divide by 0
        this.num = num;
        this.denom = denom;

        if(denom == 0){
            throw new IllegalArgumentException("/ by zero");
        }

        if(this.denom < 0){
            this.denom = -this.denom;
            this.num = -this.num;
        }


        this.num = Math.abs(num);
        this.denom = Math.abs(denom);

    }

    public Fraction(int num){
        this(num, 1);
    }

    public Fraction(){
        this(0, 1);
    }

    public int getNumerator(){
        return num;
    }

    public int getDenominator(){
        return denom;
    }

    public String toString(){
        return num + "/" + denom;
    }

    public double toDouble(){
        return (double)(num/denom);
    }

    public Fraction add(Fraction other){
        int newDen = this.denom * other.denom ;
        int newNum = (this.num * other.denom) + (other.num  * this.denom) ;

        Fraction combFraction = new Fraction(newNum, newDen);
        combFraction.toLowestTerms();
        return combFraction;
    }

    public Fraction subtract(Fraction other){
        int newDen = this.denom * other.denom ;
        int newNum = (this.num * other.denom) - (other.num  * this.denom) ;

        Fraction combFraction = new Fraction(newNum, newDen);
        combFraction.toLowestTerms();
        return combFraction;
    }

    public Fraction multiply(Fraction other){
        int newDen = this.denom * other.denom ;
        int newNum = this.num * other.num ;

        Fraction combFraction = new Fraction(newNum, newDen);
        combFraction.toLowestTerms();
        return combFraction;
    }

    public Fraction divide(Fraction other){
        //divide is the same as multiply by inverse
        int newDen = this.denom * other.num ;
        int newNum = this.num * other.denom ;

        Fraction combFraction = new Fraction(newNum, newDen);
        combFraction.toLowestTerms();
        return combFraction;
    }

    public boolean equals(Object other){
        if (!(other instanceof Fraction)){
            throw new InputMismatchException();
        }

        Fraction otherFrac = new Fraction();
        otherFrac = (Fraction)other;
        otherFrac.toLowestTerms();

        Fraction thisFrac = new Fraction(this.num, this.denom);
        thisFrac.toLowestTerms();

        if(thisFrac.num == otherFrac.num && thisFrac.denom == otherFrac.denom){
            return true;
        } else {
            return false;
        }
    }

    public void toLowestTerms(){
        int comDen = gcd(this.num, this.denom);
        this.num /=  comDen;
        this.denom /= comDen;

        if(this.denom < 0){
            this.denom = -this.denom;
            this.num = -this.num;
        }
    }

    public static int gcd(int num, int den){
        if (den == 0){
            return num;
        }
        return gcd(den, num % den);

    }

}
