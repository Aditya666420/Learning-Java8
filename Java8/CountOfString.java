import java.util.Arrays;
import java.util.List;

public class CountOfString {
	
	public static void main(String args[]) {
		List<String> list = Arrays.asList("Aditya","Sonakshi","Habibi");
		long count = list.stream().filter(c->c.startsWith("A")).count();
		System.out.println(count);
	}

}
