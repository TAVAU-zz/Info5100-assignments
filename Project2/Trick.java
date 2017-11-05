package Project2;

public class Trick extends GroupOfCards {
    private int winner;
    private Card winningCard;
    private boolean hearts = false;
    private boolean queen = false;

    public Trick(int players) {
        super(2 * players - 1);
    }

    public void update(int playNum, Card card) {
        if (isWinner(card)) {
            playNum = winner;
            winningCard = card;
        }
        if (card.getSuit() == 2 ) {
            hearts = true;
        } else if (card.getSuit() == 3 && card.getNum() == 12) {
            queen = true;
        }
    }

    public boolean isWinner(Card card) {
        if (winningCard != null) {
            if (card.getSuit() != winningCard.getSuit() || card.getNum() < winningCard.getNum()) {
                return false;
            }
        }
        return true;
    }

    //1
    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    //2
    public Card getWinningCard() {
        return winningCard;
    }

    public void setWinningCard(Card winningCard) {
        this.winningCard = winningCard;
    }

    //3
    public boolean getHearts() {
        return hearts;
    }

    public void setHearts(boolean hearts) {
        this.hearts = hearts;
    }

    //4
    public boolean getQueen() {
        return queen;
    }

    public void setQueen(boolean queen) {
        this.queen = queen;
    }
}
