package calculator;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        double result = calculator.add(10, 50);
        assertEquals(60, result, 0);
    }
    
    @Test
    public void testSub() {
        double result = calculator.subtract(50, 10);
        assertEquals(40, result, 0);
    }
    
    @Test
    public void testMulti() {
        double result = calculator.multiply(10, 5);
        assertEquals(50, result, 0);
    }
    
    @Test
    public void testDivide() {
        double result = calculator.divide(30, 5);
        assertEquals(10, result, 1);
    }
    
    @Test
    public void testDivideZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
    }
    
    @Test
    public void testAddDecimal() {
        double result = calculator.add(10.5, 20.3);
        assertEquals(30.8, result, 0.0001);
    }
    
    @Test
    public void testMultiZero() {
        double result = calculator.multiply(10, 0);
        assertEquals(0, result, 0);
    }
    
    public void testeSoma_DeveRetornarResultadoCorreto_QuandoSomaNumerosPositivos() {
        System.out.println("Testando soma de números positivos...");
        double resultado = calculator.add(10, 50);
        assertEquals(60, resultado, 0);
        System.out.println("Teste de soma concluído com sucesso!");
    }
    
    @Test
    public void testePotencia_DeveLancarExcecao_QuandoZeroElevadoANegativo() {
        System.out.println("Testando zero elevado a número negativo...");
        ArithmeticException excecao = assertThrows(ArithmeticException.class, () -> {
            calculator.pot(0, -2);
        });
        assertEquals("Zero não pode ser elevado a uma potência negativa", excecao.getMessage());
        System.out.println("Exceção foi lançada corretamente como esperado!");
    }
    
    @Test
    public void testeRaizQuadrada_DeveRetornarResultadoCorreto_QuandoNumeroPositivo() {
        System.out.println("Testando raiz quadrada de número positivo...");
        double resultado = calculator.square(16);
        assertEquals(4, resultado, 0);
        System.out.println("Resultado correto obtido!");
    }
    
    @Test
    public void testeRaizQuadrada_DeveLancarExcecao_QuandoNumeroNegativo() {
        System.out.println("Testando raiz quadrada de número negativo...");
        ArithmeticException excecao = assertThrows(ArithmeticException.class, () -> {
            calculator.square(-4);
        });
        assertEquals("Não é possível calcular raiz quadrada de número negativo", excecao.getMessage());
        System.out.println("Exceção foi lançada corretamente como esperado!");
    }
    
    @Test
    public void testePotencia_DeveRetornarResultadoCorreto_QuandoExpoenteDecimal() {
        System.out.println("Testando potência com expoente decimal...");
        double resultado = calculator.square(4);
        assertEquals(2, resultado, 0.0001);
        System.out.println("Resultado correto obtido para expoente decimal!");
    }
    
    @Test
    public void testeDividir_DeveLancarExcecao_QuandoDivisorZero() {
        System.out.println("Testando divisão por zero...");
        ArithmeticException excecao = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Não é possível dividir por zero", excecao.getMessage());
        System.out.println("Exceção foi lançada corretamente como esperado!");
    }

}
