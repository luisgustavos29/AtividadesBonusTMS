package calculator;

public class Calculator {
	 public double add(double a, double b) {
	        return a + b;
	    }
	    
	    public double subtract(double a, double b) {
	        return a - b;
	    }
	    
	    public double multiply(double a, double b) {
	        return a * b;
	    }
	    
	    public double divide(double a, double b) {
	        if (b == 0) {
	            throw new ArithmeticException("não é possível dividir por zero");
	        }
	        return a / b;
	    }
	    public double pot(double base, double exponent) {
	        if (base == 0 && exponent < 0) {
	            throw new ArithmeticException("Zero elevado a número negativo!");
	        }
	        return Math.pow(base, exponent);
	    }
	    
	    public double square(double number) {
	        if (number < 0) {
	            throw new ArithmeticException("Raiz quadrada de número negativo!");
	        }
	        return Math.sqrt(number);
	    }

}
