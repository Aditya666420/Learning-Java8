import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListConversion {
	
	public static void main(String args[]) {
		List<String> list = Arrays.asList("Aditya","Sonakshi");
		List<String> result = list.stream().map(c ->c.toLowerCase()).collect(Collectors.toList());
		System.out.print(result);
	}

}
