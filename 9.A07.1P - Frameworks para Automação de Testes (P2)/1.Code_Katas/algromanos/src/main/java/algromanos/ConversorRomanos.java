package algromanos;

public class ConversorRomanos {
    public static int converterParaArabico(String romano) {
        
        if (romano == null || romano.isEmpty()) {
            throw new IllegalArgumentException("String romana inválida");
        }

        int total = 0;          
        int estadoAtual = 0;   
        int proximoEstado;      

      
        for (int i = romano.length() - 1; i >= 0; i--) {
            char c = romano.charAt(i);
            proximoEstado = valorDoSimbolo(c);  

            if (proximoEstado < estadoAtual) {
                
                total -= proximoEstado;
            } else {
                
                total += proximoEstado;
                estadoAtual = proximoEstado;  
            }
        }
        return total;
    }

    private static int valorDoSimbolo(char simbolo) {
   
        switch (simbolo) {  
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("Símbolo romano inválido: " + simbolo);
        }
    }
}