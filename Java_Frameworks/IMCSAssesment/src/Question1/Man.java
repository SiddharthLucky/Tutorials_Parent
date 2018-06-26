package Question1;

public class Man extends Truck
{
    public void drive()
    {
        System.out.println("Man Driving.");
    }
    public void steer(int value)
    {
        System.out.println("Man steering "+value);
    }
    public void stop()
    {
        System.out.println("Man Stopped.");
    }
}
