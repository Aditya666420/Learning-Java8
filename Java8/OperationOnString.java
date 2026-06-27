import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OperationOnString {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		switch(n) {
		case 1:
			//Mapping string with their lengths
			List<String> list = Arrays.asList("Aditya","Sonakshi");
			Map<String , Integer> map = list.stream().collect(Collectors.toMap(str ->str,str-> str.length()));
			System.out.println(map);
			break;
		case 2:
			//grouping strings based on length
			List<String> list1 = Arrays.asList("java","app","sql","apple");
			Map<Integer,List<String>> m = list1.stream().collect(Collectors.groupingBy(String::length));
			System.out.println(m);
			break;
		case 3:
			// grouping strings based on starting character
			List<String> list2 = Arrays.asList("java","app","sql","apple");
			Map<Character,List<String>> m1 = list2.stream().collect(Collectors.groupingBy(s->s.charAt(0)));
			System.out.println(m1);
			break;
		case 4:
			// count of string starting with A
			List<String> list3 = Arrays.asList("Aditya","Sonakshi","Habibi");
			long count = list3.stream().filter(c->c.startsWith("A")).count();
			System.out.println(count);
			break;
		case 5:
			String k = "Java Interview";
			k=k.toLowerCase();
			/*k.chars converts to intstream 99,98,54  in order to convert
			 99 -> A
			 98 -> B
			 We are doing .mapToObj(c->(char)c) */
			Stream<Character> charStream = k.chars().mapToObj(c->(char)c);
			//character count mapping e.g Java {j=1, a=2 , v=1}
			Map<Character,Long> charFrequencyMap = charStream.collect(Collectors.groupingBy(
					c->c,LinkedHashMap::new,Collectors.counting()));
			System.out.println(charFrequencyMap);
			
			Character result = charFrequencyMap.entrySet().stream().filter(e->e.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
			System.out.println("Result :"+ result);
			break;
		case 6:
			//count frequency of each character {s=2} etc
			String k1 = "Guessand";
			Stream<Character> charS = k1.chars().mapToObj(c->(char)c);
			Map<Character,Long> cmap = charS.collect(Collectors.groupingBy(ch->ch,HashMap::new,Collectors.counting()));
			System.out.println(cmap);
			break;
		case 7:
			//Grouping based on frequency of each character {1 = [G,u,e]} etc
			String k2 = "Guessand";
			Stream<Character> charS1 = k2.chars().mapToObj(c->(char)c);
			Map<Character,Long> cmap1 = charS1.collect(
					Collectors.groupingBy(ch->ch,HashMap::new,Collectors.counting()));
			Map<Long,List<Character>> ll = cmap1.entrySet().stream().
					collect(Collectors.groupingBy(
							Map.Entry::getValue,   // 1
							Collectors.mapping(Map.Entry::getKey, Collectors.toList())));//Mapping 1 with a , G, u
			//group by freq and store it in a list.
			System.out.println(ll);
			
			break;
		case 8:
			// Reverse a string
			String b = "Ronaldo";
			String rev = IntStream.range(0, b.length()).
					mapToObj(i->b.charAt(b.length()-1-i)) // Reverses the character sequence Stream<Character>
					.map(String::valueOf) // converts the characters to string. Stream<String>
					.collect(Collectors.joining()); // converts from string stream to character.
			
			System.out.println(rev);
			break;
		case 9:
			//Find the longest string in the List of strings
			List<String> ls = Arrays.asList("Aditya","Sonakshi");
			String finalSt = ls.stream().max(Comparator.comparing(String::length)).orElse(null);
			System.out.println(finalSt);
			break;
		case 10:
			// Finding palindrome from a list of list of string.
			List<List<String>> nameList = Arrays.asList(Arrays.asList("Aditya","Nayan"),Arrays.asList("Sonakshi","Maam"));
			List<String> palString = nameList.stream()
					.flatMap(f->f.stream())
					.filter(OperationOnString::isPalindrome).collect(Collectors.toList());
			System.out.println(palString);
			break;
		case 11:
			//Remove consonants from the string
			String k3 = "Aditya";
			String removedConsonant = k3.toLowerCase().chars()
					.mapToObj(h ->(char) h).filter(x-> vowels(x))  // only keep the vowels
					.map(String:: valueOf).collect(Collectors.joining());
			System.out.println(removedConsonant);
			break;
			
		default:
			System.out.print("JMD");
			break;
		
		}
		
	}
	public static boolean vowels(Character k) {
		return k=='a' || k=='e' || k=='i'|| k=='o'|| k=='u';
	}
	public static boolean isPalindrome(String m) {
		
		String rev = IntStream.range(0, m.length())
				.mapToObj(i->m.charAt(m.length()-1-i))
				.map(String::valueOf)
				.collect(Collectors.joining());
		return rev.equalsIgnoreCase(m) ? true: false;
		
	}

}
