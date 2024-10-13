
import java.util.HashSet;
import java.util.Random;

public class BingoCard {
    private HashSet<Integer> numbers;

    public BingoCard() {
        numbers = new HashSet<>();
        generateNumbers();
    }

    private void generateNumbers() {
        Random random = new Random();
        while (numbers.size() < 5) { // Fiecare cartonaș are 5 numere
            numbers.add(random.nextInt(75) + 1); // Numere între 1 și 75
        }
    }

    public boolean checkNumber(int number) {
        return numbers.contains(number);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
