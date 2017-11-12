package Assignment7.Problem3;

public class Controller extends Thread {
    private Device device;
    private Sensor heat;
    private Sensor pressure;

    public Controller(Device device, Sensor heat, Sensor pressure) {
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    public void run() {
        device.startup();
        double t, p;
        while (true) {
            synchronized (device) {
                try {
                    device.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                t = heat.getValue();
                p = pressure.getValue();
                System.out.printf("Heat -> %.2f", t);
                System.out.printf("  Pressure -> %.2f\n", p);

            }
            if (t > 70 || p > 100) {
                device.shutdown();
                heat.interrupt();
                pressure.interrupt();
                return;
            }
            device.shutdown();
        }

    }
}
