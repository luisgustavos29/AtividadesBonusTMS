package ppt;

public class JogoPPT {
    
    public enum Movimento {
        PEDRA, PAPEL, TESOURA;
    }
    
    public enum Resultado {
        VITORIA, DERROTA, EMPATE;
    }
    
    public static Resultado determinarVencedor(Movimento jogador, Movimento oponente) {
        if (jogador == null || oponente == null) {
            throw new IllegalArgumentException("Movimentos não podem ser nulos");
        }
        
        if (jogador == oponente) {
            return Resultado.EMPATE;
        }
        
        switch (jogador) {
            case PEDRA:
                return (oponente == Movimento.TESOURA) ? Resultado.VITORIA : Resultado.DERROTA;
            case PAPEL:
                return (oponente == Movimento.PEDRA) ? Resultado.VITORIA : Resultado.DERROTA;
            case TESOURA:
                return (oponente == Movimento.PAPEL) ? Resultado.VITORIA : Resultado.DERROTA;
            default:
                throw new IllegalArgumentException("Movimento inválido");
        }
    }
    
    public static void main(String[] args) {
        // Exemplo de uso
        Movimento jogador = Movimento.PEDRA;
        Movimento oponente = Movimento.TESOURA;
        
        Resultado resultado = determinarVencedor(jogador, oponente);
        
        System.out.println("Jogador escolheu: " + jogador);
        System.out.println("Oponente escolheu: " + oponente);
        System.out.println("Resultado: " + resultado);
    }
}