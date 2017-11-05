package Project2;

public class Game {
    public final int PLAYERS;
    private Deck deck;
    private Hand[] hands;
    private Trick[] tricks;
    private int numberOfTricks = 0;
    private boolean hearts = false;
    private boolean queenOfSpades = false;

    public int getNumberOfTricks() {
        return numberOfTricks;
    }

    public boolean getHearts() {
        return hearts;
    }

    public boolean getQueenOfSpades() {
        return queenOfSpades;
    }

    public Game(int numberOfPlayers) {
        if (numberOfPlayers < 3 || numberOfPlayers > 6) throw new IllegalArgumentException("number of players must be between 3 and 6");
        PLAYERS = numberOfPlayers;
        hands = new Hand[numberOfPlayers];
        int numberOfCards = 52 / numberOfPlayers;
        for (int i = 0; i < numberOfPlayers; ++i) {
            hands[i] = new Hand(i, numberOfCards);
        }
                    //numberOfTricks
        tricks = new Trick[numberOfCards];
    }

    public void updateHeartsAndQueen(Card c) {
        if (!hearts && c.getSuit() == 2) {
            hearts = true;
            System.out.println("Hearts is now broken");
        }
        if (c.getNum() == 12 && c.getSuit() == 3) {
            queenOfSpades = true;
        }
    }

    public void playAGame() {
        deck = new Deck();
        deck.shuffle();
        int cardsLeft = 52 % PLAYERS;

        while (deck.getCurrentSize() > cardsLeft) {
            for (int i = 0; i < PLAYERS; i++) {
                hands[i].addCard(deck.dealCard());
            }
        }

        for (int i = 0; i < PLAYERS; i++) {
            hands[i].sort();
            hands[i].setShortest();
        }

        System.out.println("Output - first part:");
        System.out.println();

        int playerNum = 0;
        int clubNum = Integer.MAX_VALUE;
        for (int i = 0; i < PLAYERS; i++) {
            System.out.printf("%10s%s\n"," ","player " + i + " shortest " + hands[i].getShortest());
            hands[i].display();
            if (hands[i].getCard(52 / PLAYERS - 1).getSuit() == 0) {
                int current = hands[i].getCard(52 / PLAYERS - 1).getNum();
                if(current < clubNum) {
                    clubNum = current;
                    playerNum = i;
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Output - second part:");
        System.out.println();
        tricks[0] = new Trick(PLAYERS + cardsLeft);
        numberOfTricks++;
        Card card;
        int j = playerNum;
        do {
            if (j == playerNum) {
                card = hands[j].getCard(52 / PLAYERS - 1);
                hands[j].removeCard(52 / PLAYERS - 1);
            }
            else {
                card = hands[j].playACard(this, tricks[0]);
            }
            tricks[0].addCard(card);
            tricks[0].update(j, card);
            showPlay(j,card);
            j = (j + 1) % PLAYERS;
            if (!hearts || !queenOfSpades) {
                updateHeartsAndQueen(card);
            }

        } while (j != playerNum);

        playerNum = tricks[0].getWinner();
        while(cardsLeft > 0) {
            Card u = deck.dealCard();
            tricks[0].addCard(u);
            showPlay(-1, u);
            cardsLeft--;
        }

        for (int i = 1; i < tricks.length; i++) {
            System.out.println();
            tricks[i] = new Trick(PLAYERS);
            numberOfTricks++;
            j = playerNum;
            for (int played = 0; played < PLAYERS; played++) {
                card = hands[j].playACard(this, tricks[i]);
                tricks[i].addCard(card);
                tricks[i].update(j, card);
                showPlay(j, card);
                j = (j + 1) % PLAYERS;
                if (!hearts || !queenOfSpades) {
                    updateHeartsAndQueen(card);
                }

            }
            playerNum = tricks[i].getWinner();
        }

        System.out.println();
        for (int i = 0; i < PLAYERS; i++) {
            System.out.printf("Player %d score= %d %n", i, computePoints(i));
        }

    }

    private void showPlay(int playerNum, Card c) {
        if (playerNum == -1) {//左对齐12个字符长度
            System.out.printf("%-12s%s%n", "undealt card", c.toString());
        }
        else {
            System.out.printf("%-12s%s %n", "player " + playerNum, c.toString());
        }
    }

    private int computePoints(int playerNum) {
        int p = 0;
        for (Trick i : tricks) {
            if (i.getWinner() != playerNum) {
                continue;
            }
            if (i.getQueen()) {
                p += 13;
            }
            if (!i.getHearts()) {
                continue;
            }
            for (int j = 0; j < PLAYERS; j++) {
                if (i.getCard(j).getSuit() == 2) {
                    p += 1;
                }
            }
        }
        return p;
    }
}
