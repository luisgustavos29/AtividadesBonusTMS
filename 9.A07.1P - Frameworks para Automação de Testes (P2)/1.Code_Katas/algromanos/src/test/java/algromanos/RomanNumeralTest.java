package algromanos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @Test
    void testNumerosSimples() {
        assertEquals(1, RomanNumeral.toArabic("I"));
        assertEquals(5, RomanNumeral.toArabic("V"));
        assertEquals(10, RomanNumeral.toArabic("X"));
    }

    @Test
    void testCasosCompostos() {
        assertEquals(4, RomanNumeral.toArabic("IV"));
        assertEquals(9, RomanNumeral.toArabic("IX"));
        assertEquals(42, RomanNumeral.toArabic("XLII"));
    }

    @Test
    void testNumerosComplexos() {
        assertEquals(1989, RomanNumeral.toArabic("MCMLXXXIX"));
        assertEquals(2999, RomanNumeral.toArabic("MMCMXCIX"));
        assertEquals(1066, RomanNumeral.toArabic("MLXVI"));
    }

    @Test
    void testCaseInsensitive() {
        assertEquals(9, RomanNumeral.toArabic("ix"));
        assertEquals(2023, RomanNumeral.toArabic("mmxxiii"));
    }

    @Test
    void testEntradasInvalidas() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toArabic(null));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toArabic(""));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toArabic("ABC"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toArabic("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toArabic("VV"));
    }

    // ========== TESTES PARA toRoman() ==========
    @Test
    void testConversaoParaRomanoBasica() {
        assertEquals("I", RomanNumeral.toRoman(1));
        assertEquals("V", RomanNumeral.toRoman(5));
        assertEquals("X", RomanNumeral.toRoman(10));
    }

    @Test
    void testCasosEspeciais() {
        assertEquals("IV", RomanNumeral.toRoman(4));
        assertEquals("IX", RomanNumeral.toRoman(9));
        assertEquals("XL", RomanNumeral.toRoman(40));
    }

    @Test
    void testNumerosGrandes() {
        assertEquals("MCMLXXXIX", RomanNumeral.toRoman(1989));
        assertEquals("MMMCMXCIX", RomanNumeral.toRoman(3999));
        assertEquals("CDXLIV", RomanNumeral.toRoman(444));
    }

    @Test
    void testLimitesInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
    }

    
    @Test
    void testConversaoRoundTrip() {
        int[] numeros = {1, 4, 9, 42, 1989, 2999, 3999};
        for (int num : numeros) {
            String romano = RomanNumeral.toRoman(num);
            int arabico = RomanNumeral.toArabic(romano);
            assertEquals(num, arabico);
        }
    }
}