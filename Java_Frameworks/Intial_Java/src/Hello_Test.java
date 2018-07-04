import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletionException;
import java.util.stream.Collectors;

public class Hello_Test
{
	public static void main(String[] args) 
	{
		List<Integer> intList = new ArrayList<>();

		Random randVal = new Random();

		for(int i = 1; i< 20; i++)
		{
			intList.add(randVal.nextInt(100));
		}

		List<Integer> tempcal = new ArrayList<>();
		intList.stream()
				.mapToInt(valCheck -> valCheck + 1)
				.distinct()
				.sorted()
				.forEach(System.out::println);
	}
}
