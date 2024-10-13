
import java.util.Random;

public class GameLogic {
    private Random random;
    private boolean[] drawnNumbers;

    public GameLogic() {
        random = new Random();
        drawnNumbers = new boolean[75]; // Numere între 1 și 75
    }

    public int drawNumber() {
        int number;
        do {
            number = random.nextInt(75) + 1;
        } while (drawnNumbers[number - 1]);

        drawnNumbers[number - 1] = true; // Marcăm numărul ca extras
        return number;
    }

    public BingoCard createBingoCard() {
        return new BingoCard();
    }
}
