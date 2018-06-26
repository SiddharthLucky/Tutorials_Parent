package Question1;

public class Scania extends Truck
{
    public void drive()
    {
        System.out.println("Scania Driving.");
    }
    public void steer(int value)
    {
        System.out.println("Scania steering "+value);
    }
    public void stop()
    {
        System.out.println("Scania Stopped.");
    }
}
