package Project2;
import java.util.*;

public class Deck extends GroupOfCards{
    public static final int TOTAL_CARDS = 52;
    public static final int SUITS = 4;

    public Deck() {
        super(TOTAL_CARDS);
        for (int s = 0; s < SUITS; ++s) {
            for (int n = 2; n <= 14; ++n) {
                super.addCard(new Card(n, s));
            }
        }
    }

    public void shuffle() {
        Random random = new Random();
        int n = super.getCurrentSize();
        for (int unshuffled = n; unshuffled >= 1; unshuffled--) {
            int index = random.nextInt(n);
            super.addCard(super.removeCard(index));
        }
    }

    public Card dealCard() {
        return super.removeCard(0);
    }

    public static void main(String[] args) {
        Deck d = new Deck();
        d.display();
    }
}
