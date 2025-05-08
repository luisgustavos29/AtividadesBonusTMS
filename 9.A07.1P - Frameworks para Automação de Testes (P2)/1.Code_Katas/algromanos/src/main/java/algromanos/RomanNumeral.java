package algromanos;

public class RomanNumeral {
    public static int toArabic(String romano) {
        if (romano == null || romano.trim().isEmpty()) {
            throw new IllegalArgumentException("O numeral romano não pode ser nulo ou vazio");
        }

        int resultado = 0;
        int valorAnterior = 0;
        
        for (int i = romano.length() - 1; i >= 0; i--) {
            char simboloAtual = romano.charAt(i);
            int valorAtual = getValorSimbolo(simboloAtual);
            
            if (valorAtual < valorAnterior) {
                resultado -= valorAtual;  // Casos como IV (4), IX (9)
            } else {
                resultado += valorAtual;
                valorAnterior = valorAtual;  // Atualiza o estado
            }
        }
        
        return resultado;
    }
    
    private static int getValorSimbolo(char simbolo) {
       
        simbolo = Character.toUpperCase(simbolo);
        
 
        switch (simbolo) {
            case 'I': 
                return 1;
            case 'V': 
                return 5;
            case 'X': 
                return 10;
            case 'L': 
                return 50;
            case 'C': 
                return 100;
            case 'D': 
                return 500;
            case 'M': 
                return 1000;
            default:
                throw new IllegalArgumentException(
                    String.format("Símbolo '%c' não é um numeral romano válido", simbolo)
                );
        }
    }

  
    public static String toRoman(int numero) {
        if (numero < 1 || numero > 3999) {
            throw new IllegalArgumentException("Número deve estar entre 1 e 3999");
        }

      
        int[] valores = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] simbolos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romano = new StringBuilder();
        
     
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                romano.append(simbolos[i]);
                numero -= valores[i];
            }
        }
        
        return romano.toString();
    }
}