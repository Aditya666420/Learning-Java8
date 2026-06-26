import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstUnique {

	public static void main(String args[]) {
		String s ="stress";
		Stream<Character> ch = s.chars().mapToObj(c->(char)c);
		Map<Character,Long> freQmap = ch.collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()));
		//contains { a=[a,a]} but after applying counting {a= 2} like this for others
		Optional<Character> result = freQmap.entrySet().stream().filter(key -> key.getValue()==1)
										.map(Map.Entry::getKey).findFirst(); // Getting the unique key {a=1}
		// a is the key with value 1.
		System.out.println(result.get());
		// Non java 8
//		b=b.toLowerCase();
//		for(int i=0;i<b.length();i++) {
//			int count =0;
//			for(int j=0;j<b.length();j++) {
//				if(b.charAt(i)==b.charAt(j)) {
//					count++;
//				}
//			}
//			if(count==1) {
//				System.out.print(b.charAt(i));
//				break;
//			}
//		}
	}
}
