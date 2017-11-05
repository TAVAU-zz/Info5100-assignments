package Project2;

public class GroupOfCards {
    private Card[] cards;
    private int currentSize = 0;

    GroupOfCards(int size){
        if (size >= 0 && size <= 52) {
            cards = new Card[size];
        } else {
            throw new IllegalArgumentException("Not a valid size");
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }

    //
    public Card getCard(int i) {
        return cards[i];
    }

    public void addCard(Card card) {
        cards[currentSize++] = card;
    }

    public Card removeCard(int index) {
        currentSize--;
        Card card = cards[index];
        for (int j = index; j < currentSize; ++j) {
            cards[j]=cards[j+1];
        }
        cards[currentSize]=null;
        return card;
    }

    public void display() {
        for (Card c:cards) {
            c.display();
        }
    }

    public static void main(String[] args) {
        GroupOfCards g = new GroupOfCards(1);

        g.addCard(new Card(2,3));
        g.display();
    }

}
