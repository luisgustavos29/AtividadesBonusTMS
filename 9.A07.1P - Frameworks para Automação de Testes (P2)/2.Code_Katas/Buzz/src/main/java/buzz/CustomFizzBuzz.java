package buzz;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomFizzBuzz {
    
    private final LinkedHashMap<Integer, String> replacements;
    
    public CustomFizzBuzz() {
        this.replacements = new LinkedHashMap<>();
    }
    
    public void addReplacement(int divisor, String word) {
        replacements.put(divisor, word);
    }
    
    public String evaluate(int number) {
        StringBuilder result = new StringBuilder();
        
        for (Map.Entry<Integer, String> entry : replacements.entrySet()) {
            if (number % entry.getKey() == 0) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(entry.getValue());
            }
        }
        
        return result.length() > 0 ? result.toString() : String.valueOf(number);
    }
}