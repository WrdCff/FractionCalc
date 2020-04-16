import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");
        System.out.println("--------------------------------------------------------------------------------");

        String operator = getOperation();

        while (!operator.equalsIgnoreCase("Q")){
            Fraction firstFraction = getFraction();
            Fraction secondFraction = getFraction();
            Fraction answer = new Fraction(1,1);

            if(operator.equals("+")){
                answer = firstFraction.add(secondFraction);
            } else if (operator.equals("-")){
                answer = firstFraction.subtract(secondFraction);
            } else if (operator.equals("*")){
                answer = firstFraction.multiply(secondFraction);
            } else if (operator.equals("/")){
                answer = firstFraction.divide(secondFraction);
            }
            System.out.println(answer);
            System.out.println("--------------------------------------------------------------------------------");

            operator = getOperation();
        }
    }

    public static String getOperation(){
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter an operation (+, -, /, = or Q to quit: ");
        String operation = input.next();
        while (!operation.equals("+") &&
                !operation.equals("-") &&
                !operation.equals("/") &&
                !operation.equals("*") &&
                !operation.equalsIgnoreCase("q")) {
            System.out.print("Please enter a valid operation (+, -, /, = or Q to quit: ");
            operation = input.next();
        }
        return operation;
    }

    public static boolean validFraction(String input) {
        if (input.contains("/")) {
            String[] parts = input.split("/", 2);
            if (parts[0].matches("-?\\d+") && parts[1].matches("-?\\d+")) {
                return true;
            } else {
                return false;
            }
        } else {
            if (input.matches("-?\\d+")) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static Fraction getFraction(){
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String aFrac = input.next();

        boolean valid = validFraction(aFrac);
        while (!valid){
            System.out.print("Invalid Fraction. Please enter (a/b) or (a), where a and b are integers and b is not 0: ");
            aFrac = input.next();
            valid = validFraction(aFrac);
        }

        if (aFrac.contains("/")){
            String[] answer = aFrac.split("/");
            return new Fraction(Integer.parseInt(answer[0]), Integer.parseInt(answer[1]));
        } else {
            return new Fraction(Integer.parseInt(aFrac));
        }


    }
}
