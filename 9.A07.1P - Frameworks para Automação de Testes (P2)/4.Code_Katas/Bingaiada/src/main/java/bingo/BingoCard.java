package bingo;
import java.util.*;

public class BingoCard {
    private static final int SIZE = 5;
    private static final int FREE_ROW = 2;
    private static final int FREE_COL = 2;
    private static final Map<String, int[]> COLUMN_RANGES = Map.of(
        "B", new int[]{1, 15},
        "I", new int[]{16, 30},
        "N", new int[]{31, 45},
        "G", new int[]{46, 60},
        "O", new int[]{61, 75}
    );

    private final int[][] numbers;

    public BingoCard() {
        numbers = new int[SIZE][SIZE];
        generateCard();
    }

    private void generateCard() {
        String[] columns = {"B", "I", "N", "G", "O"};
        for (int col = 0; col < SIZE; col++) {
            int[] range = COLUMN_RANGES.get(columns[col]);
            List<Integer> columnNumbers = new ArrayList<>();
            for (int i = range[0]; i <= range[1]; i++) {
                columnNumbers.add(i);
            }
            Collections.shuffle(columnNumbers);
            
            for (int row = 0; row < SIZE; row++) {
                if (row == FREE_ROW && col == FREE_COL) {
                    numbers[row][col] = 0; // FREE space
                } else {
                    numbers[row][col] = columnNumbers.get(row);
                }
            }
        }
    }

    public int[][] getNumbers() {
        return Arrays.stream(numbers).map(int[]::clone).toArray(int[][]::new);
    }

    public boolean isWinner(List<Integer> calledNumbers) {
        // Check rows
        for (int row = 0; row < SIZE; row++) {
            if (checkLine(row, 0, 0, 1, calledNumbers)) return true;
        }
        
        // Check columns
        for (int col = 0; col < SIZE; col++) {
            if (checkLine(0, col, 1, 0, calledNumbers)) return true;
        }
        
        // Check diagonals
        return checkLine(0, 0, 1, 1, calledNumbers) || 
               checkLine(0, SIZE-1, 1, -1, calledNumbers);
    }

    private boolean checkLine(int startRow, int startCol, int rowStep, int colStep, List<Integer> calledNumbers) {
        for (int i = 0; i < SIZE; i++) {
            int num = numbers[startRow + i*rowStep][startCol + i*colStep];
            if (num != 0 && !calledNumbers.contains(num)) {
                return false;
            }
        }
        return true;
    }
}