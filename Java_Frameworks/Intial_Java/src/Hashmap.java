import java.util.HashMap;

public class Hashmap
{
    public static void main(String[] args)
    {
        HashMap<Integer, String> hmap = new HashMap<>();

        hmap.put(1,"sid");

        if(hmap.containsKey(1));
        {
            System.out.println("Present");
        }
        hmap.put(1,"saber");

        System.out.println(hmap.get(1));
    }
}
