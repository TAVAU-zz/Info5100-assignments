package Assignment7.Problem3;

public class Device {
    private double heat;
    private double pressure;

    public double getHeat() {
        return heat;
    }

    public void setHeat(double heat) {
        this.heat = heat;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }


    // print to console that device is starting
    public void startup() {
        System.out.println("starting now");
    }

    // print to console that device is shutting down and exit
    public void shutdown() {
        System.out.println("shutting down and exit now");
    }
}
