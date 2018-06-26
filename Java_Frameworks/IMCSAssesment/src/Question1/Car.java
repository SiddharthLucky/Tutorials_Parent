package Question1;

public class Car implements Vehicle
{
    private int wheels;
    private int doors;

    public Car(int wheels, int doors)
    {
            this.wheels = wheels;
            this.doors = doors;
    }

    public int getWheels()
    {
        return wheels;
    }

    public void setWheels(int wheels)
    {
        this.wheels = wheels;
    }

    public int getDoors()
    {
        return doors;
    }

    public void setDoors(int doors)
    {
        this.doors = doors;
    }

    @Override
    public void drive()
    {
        System.out.println("Car Driving.");
    }

    @Override
    public void steer(int value)
    {
        System.out.println("Car Steering: "+value);
    }

    @Override
    public void stop()
    {
        System.out.println("Car Stopped.");
    }
}
