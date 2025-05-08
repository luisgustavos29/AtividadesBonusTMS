package bingo;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BingoGameTest {
    private BingoGame game;
    private BingoCard card;

    @BeforeEach
    void setUp() {
        game = new BingoGame();
        card = new BingoCard();
        game.addCard(card);
    }

    @Test
    @DisplayName("BingoCaller should call numbers between 1 and 75")
    void callerGeneratesValidNumbers() {
        IntStream.range(0, 75).forEach(i -> {
            int number = game.callNumber();
            assertTrue(number >= 1 && number <= 75, 
                "Called number should be between 1 and 75");
        });
    }

    @Test
    @DisplayName("BingoCaller should not repeat numbers")
    void callerGeneratesUniqueNumbers() {
        List<Integer> calledNumbers = IntStream.range(0, 75)
            .mapToObj(i -> game.callNumber())
            .toList();
        
        assertEquals(75, calledNumbers.stream().distinct().count(),
            "All 75 numbers should be unique");
    }

    @Test
    @DisplayName("BingoCard should have correct structure")
    void cardHasCorrectStructure() {
        int[][] numbers = card.getNumbers();
        
       
        assertEquals(5, numbers.length, "Card should have 5 rows");
        assertEquals(5, numbers[0].length, "Card should have 5 columns");
        
        
        assertEquals(0, numbers[2][2], "Center space should be FREE (0)");
        
        
        assertAll(
            () -> assertColumnInRange(numbers, 0, 1, 15, "B"),
            () -> assertColumnInRange(numbers, 1, 16, 30, "I"),
            () -> assertColumnInRange(numbers, 2, 31, 45, "N"),
            () -> assertColumnInRange(numbers, 3, 46, 60, "G"),
            () -> assertColumnInRange(numbers, 4, 61, 75, "O")
        );
    }

    private void assertColumnInRange(int[][] numbers, int col, int min, int max, String columnName) {
        for (int row = 0; row < 5; row++) {
            if (row == 2 && col == 2) continue; // Skip free space
            int num = numbers[row][col];
            assertTrue(num >= min && num <= max,
                columnName + " column should be between " + min + "-" + max);
        }
    }

    @Test
    @DisplayName("Game should detect winning card with complete row")
    void detectsWinningRow() {
        int[][] numbers = card.getNumbers();
        int[] winningRow = numbers[0]; // First row
        
       
        Arrays.stream(winningRow)
              .filter(n -> n != 0)
              .forEach(n -> game.callNumber());
        
        assertNotNull(game.checkForWinner(), "Should detect winning row");
    }

    @Test
    @DisplayName("Game should detect winning card with complete column")
    void detectsWinningColumn() {
        int[][] numbers = card.getNumbers();
        
        for (int row = 0; row < 5; row++) {
            if (numbers[row][0] != 0) {
                game.callNumber();
            }
        }
        
        assertNotNull(game.checkForWinner(), "Should detect winning column");
    }

    @Test
    @DisplayName("Game should not detect winner with incomplete card")
    void noFalsePositives() {
        IntStream.range(0, 4).forEach(i -> game.callNumber());
        
        assertNull(game.checkForWinner(), "Should not detect winner with incomplete card");
    }

    @Test
    @DisplayName("Game reset should clear called numbers")
    void gameResetWorks() {
        IntStream.range(0, 10).forEach(i -> game.callNumber());
        game.reset();
        assertEquals(0, game.callNumber(), "Should start from beginning after reset");
    }
}