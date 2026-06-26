import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharacters {
	
	public static void main(String args[]) {
		
		String a ="AdityaNath";
//		HashMap<Character,Integer> map = new HashMap<>();
		a = a.toLowerCase();
//		for(int i=0;i<a.length();i++) {
//			int count =0;
//			for(int j=0;j<a.length();j++) {
//				
//				if(a.charAt(i)==a.charAt(j)) {
//					count++;
//					
//				}
//				
//			}
//			map.put(a.charAt(i), count);
//			
//		}
//		for(Entry<Character, Integer> p : map.entrySet()) {
//			System.out.println("No. of "+p.getKey()+" is "+p.getValue());
//		}
		
		// Java 8 stsyle
		Map<Character, Integer> map = new HashMap<>();
		 a.chars() //--> returns int sream
        .mapToObj(c -> (char) c) //--> converts integers in characters
        .forEach(ch -> map.merge(ch, 1, Integer::sum)); // --> if map is empty {} for a it will return {a =1} first.
		 
		 map.forEach((key,value)->
		 System.out.println("No of "+key+" is "+value)
		 );
		 
		 

		
		
	}

}
