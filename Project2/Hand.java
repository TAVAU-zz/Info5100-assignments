package Project2;

public class Hand extends GroupOfCards{
    public final int NUM;
    private int shortest;

    public Hand(int playerNum, int numberOfCards) {
        super(numberOfCards);
        NUM = playerNum;
    }

    public void sort() {
        int unsorted = super.getCurrentSize();
        for (int i = unsorted; i >= 1; i--) {

            int index = 0;
            for (int j = 0;j < i; j++) {
                int total = super.getCard(j).getSuit() * 13 + super.getCard(j).getNum();
                int temp = super.getCard(index).getSuit() * 13 + super.getCard(index).getNum();
                if (total > temp) {
                    index = j;
                }
            }
            super.addCard(super.removeCard(index));
        }
    }

    public int getShortest() {
        return shortest;
    }

    public void setShortest() {
        int diamonds = 0, clubs = 0, spades = 0;
        shortest = 0;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getSuit() == 0 ) {
                clubs++;
                continue;
            }
            if (getCard(i).getSuit() == 1) {
                diamonds++;
                continue;
            }
            if (getCard(i).getSuit() == 3) {
                spades++;
                continue;
            }
        }
        if (diamonds <= clubs) {
            shortest = 1;
        }
        if (spades <= Math.min(diamonds, clubs)
                && !findAceKingQueen(14,3)
                && !findAceKingQueen(13,3)
                && !findAceKingQueen(12,3)) {
            shortest = 3;
        }
    }

    public Card playACard(Game game, Trick trick) {
        int index;
        if (trick.getCurrentSize() == 0) {
            index = findHighest(shortest) == -1? findLowest(game): findHighest(shortest);
        }
        else if (trick.getCurrentSize() == game.PLAYERS-1
                && !trick.getHearts() && !trick.getQueen()
                && (index = findLastHigh(trick.getWinningCard().getSuit())) >= 0);
        else if ((index = findHighestBelow(trick.getWinningCard())) >= 0);
        else if ((index = findMiddleHigh(game, trick.getWinningCard().getSuit())) >= 0);
        else if ((index = find(12, 3)) >= 0); // queen of Spades
        else if ((index = find(14, 3)) >= 0); // Ace of Spades
        else if ((index = find(13, 3)) >= 0); // King of Spades
        else if ((index = findHighest(2)) >= 0); // heart
        else {
            index = findHighest();
        }
        Card c = this.removeCard(index);
        trick.update(NUM, c);
        //update the game
        return c;
    }

    private int findHighest() {
        int max= Integer.MIN_VALUE,index=0;
        for (int i = 0; i < this.getCurrentSize(); ++i) {
            if (this.getCard(i).getNum() > max) {
                max = this.getCard(i).getNum();
                index = i;
            }
        }
        return max==Integer.MIN_VALUE? -1: index;
    }

    private int findHighest(int suit) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i) == null) {
                break;
            }
            if (getCard(i).getSuit() != suit) {
                continue;
            }
            max = Math.max(max, getCard(i).getNum());
        }
        return max == Integer.MIN_VALUE? -1: find(max, suit);
    }

    public int findLowest(int suit) {
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i) == null) {
                break;
            }
            if (getCard(i).getSuit() != suit) {
                continue;
            }
            min = Math.min(min, getCard(i).getNum());
        }
        return min == Integer.MAX_VALUE? -1: find(min, suit);
    }

    private int findCount(int suit) {
        int count = 0;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i).getSuit() != suit) {
                continue;
            }
            count++;
        }
        return count;
    }

    private boolean findAceKingQueen(int num, int suit) {
        for (int i = 0; i < this.getCurrentSize(); ++i) {
            if (this.getCard(i).getNum() == num && this.getCard(i).getSuit() == suit) {
                return true;
            }
        }
        return false;
    }

    private int find(int num, int suit) {
        for (int i = 0; i < this.getCurrentSize(); ++i) {
            if (this.getCard(i).getNum() == num && this.getCard(i).getSuit() == suit) {
                return i;
            }
        }
        return -1;
    }

    private int findLastHigh(int suit) {
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i) == null) {
                break;
            }
            if (getCard(i).getSuit()!=suit) {
                continue;
            }
            if (getCard(i).getSuit() == 3 && getCard(i).getNum() == 12) {
                continue;
            }
            max=Math.max(max, getCard(i).getNum());
        }
        return max==Integer.MIN_VALUE? -1:find(max, suit);
    }

    private int findHighestBelow(Card winningCard) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i) == null) {
                break;
            }
            if (getCard(i).getSuit() != winningCard.getSuit()) {
                continue;
            }
            if (getCard(i).getNum() < winningCard.getNum()) {
                max = Math.max(max, getCard(i).getNum());
            }
        }
        return max == Integer.MIN_VALUE? -1: find(max, winningCard.getSuit());
    }

    private int findMiddleHigh(Game game, int suit) {
        if(suit == 3 && !game.getQueenOfSpades()) {
            return findHighestBelow(new Card(11,3));
        }
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < getCurrentSize(); i++) {
            if (getCard(i) == null) {
                break;
            }
            if (getCard(i).getSuit()!=suit) {
                continue;
            }
            max=Math.max(max, getCard(i).getNum());
        }
        return max == Integer.MIN_VALUE? -1: find(max, suit);

    }

    private int findLowest(Game game) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < this.getCurrentSize(); ++i) {
            if (!game.getHearts() && this.getCard(i).getSuit() == 2) {
                continue;
            }
            if (this.getCard(i).getNum() < min) {
                min = this.getCard(i).getNum();
                index = i;
            }
        }
        return min == Integer.MAX_VALUE? -1: index;
    }
}
