package Question3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass
{
    public static void main(String[] args)
    {
        Product p1 = new Product(1, "sail", 200, 2);
        Product p2 = new Product(2, "sailfish1", 200, 3);
        Product p3 = new Product(3, "sailfish2", 1.2321, 5);
        Product p4 = new Product(4, "sailfish3", 200, 9);

        List<Product> prodsList = new ArrayList<Product>();
        prodsList.add(p1);
        prodsList.add(p2);
        prodsList.add(p3);
        prodsList.add(p4);

        prodsList.stream()
                .filter(product -> product.getPrice() > 100)
                .filter(product -> product.getStock() > 1 && product.getStock() < 10)
                .sorted((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                .collect(Collectors.toList());

        for(Product p : prodsList)
        {
            System.out.println("Product Name: "+p.getName());
        }
    }
}
