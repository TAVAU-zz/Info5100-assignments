package Assignment6;

public class MyIndexOutOfBoundException extends Exception {
    private int lowerBound;
    private int upperBound;
    private int index;

    public MyIndexOutOfBoundException() {
        super();
    }

    public MyIndexOutOfBoundException(String message) {
        super(message);
    }

    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.index = index;
        System.out.println("\"Error Message: " + "Index: " + this.index + ", but Lower bound: "
                + lowerBound + ", Upper bound: " + upperBound + "\"" + "\n");
    }

    MyIndexOutOfBoundException(int lowerBound, int upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public static void main(String[] args) {
        //MyIndexOutOfBoundException object = new MyIndexOutOfBoundException();
        int low = 0;
        int high = 9;
        int index = 10;
        try {
            indexOutOfBoundException(low, high, index);
        } catch (MyIndexOutOfBoundException e) {
            e.printStackTrace();
        }

    }

    public static void indexOutOfBoundException(int lowerBound, int upperBound, int index) throws MyIndexOutOfBoundException {
        if (index >= lowerBound && index <= upperBound) {
            return;
        } else {
            throw new MyIndexOutOfBoundException(lowerBound, upperBound, index);
        }
    }



}
