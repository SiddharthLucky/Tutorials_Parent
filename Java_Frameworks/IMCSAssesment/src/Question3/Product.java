package Question3;

public class Product
{
    private int id;
    private String Name;
    private double price;
    private int stock;

    public Product(int id, String Name, double price, int stock)
    {
        this.id = id;
        this.Name = Name;
        this.price = price;
        this. stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean checkStock()
    {
        if(getStock()>=1.0 && getStock()<=10)
        {
            return true;
        }
        return false;
    }
}
