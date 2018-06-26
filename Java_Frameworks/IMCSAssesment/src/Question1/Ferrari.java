package Question1;

public class Ferrari extends Car
{
    private String badge;

    public String getBadge()
    {
        return badge;
    }

    public void setBadge(String badge)
    {
        this.badge = badge;
    }

    public Ferrari(int wheels, int doors)
    {
        super(wheels, doors);
        setBadge("Ferrari.");
    }

    public void foo()
    {
        System.out.println("Printing Foo.");
    }
}
