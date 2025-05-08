import static org.junit.Assert.*;
import org.junit.Test;

public class JogoPPTTest {
    
    @Test
    public void testPedraVenceTesoura() {
        assertEquals(Resultado.VITORIA, JogoPPT.determinarVencedor(Movimento.PEDRA, Movimento.TESOURA));
        assertEquals(Resultado.DERROTA, JogoPPT.determinarVencedor(Movimento.TESOURA, Movimento.PEDRA));
    }
    
    @Test
    public void testPapelVencePedra() {
        assertEquals(Resultado.VITORIA, JogoPPT.determinarVencedor(Movimento.PAPEL, Movimento.PEDRA));
        assertEquals(Resultado.DERROTA, JogoPPT.determinarVencedor(Movimento.PEDRA, Movimento.PAPEL));
    }
    
    @Test
    public void testTesouraVencePapel() {
        assertEquals(Resultado.VITORIA, JogoPPT.determinarVencedor(Movimento.TESOURA, Movimento.PAPEL));
        assertEquals(Resultado.DERROTA, JogoPPT.determinarVencedor(Movimento.PAPEL, Movimento.TESOURA));
    }
    
    @Test
    public void testEmpates() {
        assertEquals(Resultado.EMPATE, JogoPPT.determinarVencedor(Movimento.PEDRA, Movimento.PEDRA));
        assertEquals(Resultado.EMPATE, JogoPPT.determinarVencedor(Movimento.PAPEL, Movimento.PAPEL));
        assertEquals(Resultado.EMPATE, JogoPPT.determinarVencedor(Movimento.TESOURA, Movimento.TESOURA));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMovimentoNuloJogador() {
        JogoPPT.determinarVencedor(null, Movimento.PEDRA);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMovimentoNuloOponente() {
        JogoPPT.determinarVencedor(Movimento.PEDRA, null);
    }
}