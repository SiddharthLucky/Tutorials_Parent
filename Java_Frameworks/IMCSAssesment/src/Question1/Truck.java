package Question1;

public class Truck implements Vehicle
{

    @Override
    public void drive()
    {
        System.out.println("Truck Driving.");
    }

    @Override
    public void steer(int value)
    {
        System.out.println("Truck Steering: "+value);
    }

    @Override
    public void stop()
    {
        System.out.println("Truck Stopped.");
    }
}

