package Assignment7;

public class MaxVaule extends Thread{
    private int lo ,hi;
    private int[] arr;
    private int max = 0;

    public MaxVaule(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = lo; i < hi; i++) {
            max = Math.max(max, arr[i]);

        }
        //System.out.println("-------");
    }
    public static int maxValue(int[] arr) throws InterruptedException {
        int len = arr.length;
        int maxVal = 0;

        // Create and start 4 threads.
        MaxVaule[] ts = new MaxVaule[4];
        for (int i = 0; i < 4; i++) {
            ts[i] = new MaxVaule(arr, (i * len) / 4, ((i + 1) * len / 4));
            ts[i].start();
        }

        for (int i = 0; i < 4; i++) {
            ts[i].join();
            maxVal = Math.max(maxVal, ts[i].max);

        }
        //System.out.println(maxVal);
        return maxVal;
    }
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,9,2,6,3,7,8,5,4,0};
        int maxValue = maxValue(arr);
        System.out.println("max value: " + maxValue);
    }
}
