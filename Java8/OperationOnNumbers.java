import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperationOnNumbers {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number :");
		int n = sc.nextInt();
		switch(n) {
			case 1:
				List<Integer> list = Arrays.asList(1,0,7,9);
				int maxN = list.stream().max(Integer::compareTo).get();
				System.out.println(maxN);
				break;
			case 2:
				// Finding second highest
				List<Integer> list1 = Arrays.asList(1,0,7,9);
				int number = list1.stream().sorted((a,b)->b-1).skip(1).findFirst().get();
				System.out.println("Second highest : "+ number);
				break;
			case 3:
				//Finding duplicate
				List<Integer> list2 = Arrays.asList(1,1,1,2,3);
				Set<Integer> set = new HashSet<>();
				List<Integer> dupList = list2.stream().filter(s -> !set.add(s)).distinct().collect(Collectors.toList());
				System.out.println(dupList);
				break;
			case 4:
				//separate odd and even number List
				List<Integer> list3 = Arrays.asList(1,0,2,4,7,9);
				Map<Boolean,List<Integer>> ll = list3.stream().collect(Collectors.partitioningBy(g-> g%2==0 && g!=0));
				System.out.println("Even :"+ ll.get(true));
				System.out.print("Odd "+ ll.get(false));
				break;
			case 5:
				//merge two lists and remove duplicate and in sorted order
				List<List<Integer>> list4 = Arrays.asList(Arrays.asList(1,0,2,4,7,9),Arrays.asList(1,6,3,8));
				List<Integer> mergedList = list4.stream().flatMap(m->m.stream()).distinct().sorted().collect(Collectors.toList());
				System.out.println("Merged List is : "+mergedList);
				break;
			 default:
				System.out.print("Fuck off");
				break;
		}
				
		
	}
	

}
