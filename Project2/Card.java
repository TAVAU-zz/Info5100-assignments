package Project2;

public class Card {
    private int num;
    private int suit;

    public Card(int num, int suit) {
        this.num = num;
        this.suit = suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getNum() {
        return num;
    }

    public int getSuit() {
        return suit;
    }

    public void setNum(int num) {

        this.num = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (num > 10) {
            switch (num) {
                case 11:
                    sb.append("Jack of ");
                    break;
                case 12:
                    sb.append("Queen of ");
                    break;
                case 13:
                    sb.append("King of ");
                    break;
                case 14:
                    sb.append("Ace of ");
                    break;
            }
        } else {
            sb.append(num);
            sb.append(" of ");
        }
        switch (suit) {
            case 0:
                sb.append("clubs");
                break;
            case 1:
                sb.append("diamonds");
                break;
            case 2:
                sb.append("hearts");
                break;
            case 3:
                sb.append("spades");
                break;
        }
        return sb.toString();
    }

    public void display() {
        System.out.println(this);
    }

    public static void main(String[] args) {

        Card a= new Card(14,2);
        a.display();

    }

}
