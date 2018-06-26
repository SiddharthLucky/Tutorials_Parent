package Question1;

public class AstonMartin extends Car
{
    private String label;

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public AstonMartin(int wheels, int doors)
    {
        super(wheels, doors);
        setLabel("Aston Martin");
    }

    public void bar()
    {
        System.out.println("Printing bar.");
    }

}
