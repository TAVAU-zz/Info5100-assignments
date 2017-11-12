package Assignment7;

public class ReverseHello extends Thread{
    int counter;

    public ReverseHello(int counter){
        this.counter = counter;
    }
    public void run()
    {
        if(counter < 50)
        {
            createThread(counter + 1);
        }
        System.out.println("Hello from Thread num " + counter);
    }

    public void createThread(int counter) {
        ReverseHello t = new ReverseHello(counter);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] arg){
        ReverseHello t = new ReverseHello(1);
        t.start();
    }
}
