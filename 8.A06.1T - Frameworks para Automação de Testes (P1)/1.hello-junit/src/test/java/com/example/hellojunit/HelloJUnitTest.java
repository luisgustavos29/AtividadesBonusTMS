package com.example.hellojunit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HelloJUnitTest {
	 @Test
	    public void testSayHello() {
	        HelloJUnit hello = new HelloJUnit();
	        String result = hello.sayHello();
	        assertEquals("Hello, World of Tests!", result);
	    }
}
