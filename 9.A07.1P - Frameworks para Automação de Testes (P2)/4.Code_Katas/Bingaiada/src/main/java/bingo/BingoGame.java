package bingo;

import java.util.ArrayList;
import java.util.List;

public class BingoGame {
    private final BingoCaller caller;
    private final List<BingoCard> cards;
    private final List<Integer> calledNumbers;

    public BingoGame() {
        this.caller = new BingoCaller();
        this.cards = new ArrayList<>();
        this.calledNumbers = new ArrayList<>();
    }

    public void addCard(BingoCard card) {
        cards.add(card);
    }

    public int callNumber() {
        int number = caller.callNumber();
        calledNumbers.add(number);
        return number;
    }

    public BingoCard checkForWinner() {
        return cards.stream()
                   .filter(card -> card.isWinner(calledNumbers))
                   .findFirst()
                   .orElse(null);
    }

    public void reset() {
        caller.reset();
        calledNumbers.clear();
    }
}