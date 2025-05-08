package buzz;

public class FizzBuzzPop extends FizzBuzz{
	 @Override
	    public String evaluate(int number) {
	        if (number % 105 == 0) {
	            return "fizz buzz pop";
	        } else if (number % 35 == 0) {
	            return "buzz pop";
	        } else if (number % 21 == 0) {
	            return "fizz pop";
	        } else if (number % 7 == 0) {
	            return "pop";
	        } else {
	            return super.evaluate(number);
	        }
	    }
}
