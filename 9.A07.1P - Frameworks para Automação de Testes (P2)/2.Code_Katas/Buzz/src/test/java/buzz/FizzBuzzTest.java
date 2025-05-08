package buzz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FizzBuzzTest {
    
    @Test
    public void testNormalNumbers() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("1", fb.evaluate(1));
        assertEquals("2", fb.evaluate(2));
        assertEquals("4", fb.evaluate(4));
    }
    
    @Test
    public void testMultiplesOfThree() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("fizz", fb.evaluate(3));
        assertEquals("fizz", fb.evaluate(9));
        assertEquals("fizz", fb.evaluate(123));
    }
    
    @Test
    public void testMultiplesOfFive() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("buzz", fb.evaluate(5));
        assertEquals("buzz", fb.evaluate(20));
        assertEquals("buzz", fb.evaluate(200));
    }
    
    @Test
    public void testMultiplesOfThreeAndFive() {
        FizzBuzz fb = new FizzBuzz();
        assertEquals("fizz buzz", fb.evaluate(15));
        assertEquals("fizz buzz", fb.evaluate(45));
        assertEquals("fizz buzz", fb.evaluate(315));
    }
    
    // Testes para FizzBuzzPop
    @Test
    public void testMultiplesOfSeven() {
        FizzBuzzPop fbp = new FizzBuzzPop();
        assertEquals("pop", fbp.evaluate(7));
        assertEquals("pop", fbp.evaluate(28));
        assertEquals("pop", fbp.evaluate(77));
    }
    
    @Test
    public void testMultiplesOfThreeAndSeven() {
        FizzBuzzPop fbp = new FizzBuzzPop();
        assertEquals("fizz pop", fbp.evaluate(21));
        assertEquals("fizz pop", fbp.evaluate(63));
        assertEquals("fizz pop", fbp.evaluate(126));
    }
    
    @Test
    public void testMultiplesOfFiveAndSeven() {
        FizzBuzzPop fbp = new FizzBuzzPop();
        assertEquals("buzz pop", fbp.evaluate(35));
        assertEquals("buzz pop", fbp.evaluate(70));
        assertEquals("buzz pop", fbp.evaluate(140));
    }
    
    @Test
    public void testMultiplesOfThreeFiveAndSeven() {
        FizzBuzzPop fbp = new FizzBuzzPop();
        assertEquals("fizz buzz pop", fbp.evaluate(105));
        assertEquals("fizz buzz pop", fbp.evaluate(210));
        assertEquals("fizz buzz pop", fbp.evaluate(315));
    }
    
    // Testes para CustomFizzBuzz
    @Test
    public void testCustomSingleReplacement() {
        CustomFizzBuzz cfb = new CustomFizzBuzz();
        cfb.addReplacement(2, "fuzz");
        
        assertEquals("1", cfb.evaluate(1));
        assertEquals("fuzz", cfb.evaluate(2));
        assertEquals("fuzz", cfb.evaluate(8));
    }
    
    @Test
    public void testCustomMultipleReplacements() {
        CustomFizzBuzz cfb = new CustomFizzBuzz();
        cfb.addReplacement(2, "fuzz");
        cfb.addReplacement(3, "bizz");
        
        assertEquals("fuzz", cfb.evaluate(4));
        assertEquals("bizz", cfb.evaluate(9));
        assertEquals("fuzz bizz", cfb.evaluate(12));
    }
}