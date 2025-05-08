package algromanos;

public class Main {

	 public static void main(String[] args) {
		 // Testes para toArabic()
	        System.out.println(RomanNumeral.toArabic("IX"));      // 9
	        System.out.println(RomanNumeral.toArabic("xii"));     // 12 (case-insensitive)
	        System.out.println(RomanNumeral.toArabic("MCMLXXXIX")); // 1989
	        
	        // Testes para toRoman()
	        System.out.println(RomanNumeral.toRoman(4));         // IV
	        System.out.println(RomanNumeral.toRoman(1989));      // MCMLXXXIX
	        System.out.println(RomanNumeral.toRoman(3999));      // MMMCMXCIX
	    }
	}