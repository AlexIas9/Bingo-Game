
public class Player {
    private String name;
    private BingoCard bingoCard;

    public Player(String name, BingoCard bingoCard) {
        this.name = name;
        this.bingoCard = bingoCard;
    }

    public String getName() {
        return name;
    }

    public BingoCard getBingoCard() {
        return bingoCard;
    }
}
