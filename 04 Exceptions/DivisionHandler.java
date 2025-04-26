public class DivisionHandler {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            double result = calculate(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static double performDivision(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) numerator / denominator;
    }

    public static double calculate(int numerator, int denominator) {
        try {
            return performDivision(numerator, denominator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Error in calculation: " + e.getMessage());
        }
    }
}
