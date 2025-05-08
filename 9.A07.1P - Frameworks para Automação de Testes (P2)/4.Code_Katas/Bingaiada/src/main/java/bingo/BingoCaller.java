package bingo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoCaller {
    private List<Integer> numbers;
    private int currentIndex;

    public BingoCaller() {
        reset();
    }

    public int callNumber() {
        if (currentIndex >= numbers.size()) {
            throw new IllegalStateException("All numbers have been called");
        }
        return numbers.get(currentIndex++);
    }

    public void reset() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 75; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        currentIndex = 0;
    }

    public List<Integer> getCalledNumbers() {
        return new ArrayList<>(numbers.subList(0, currentIndex));
    }
}
