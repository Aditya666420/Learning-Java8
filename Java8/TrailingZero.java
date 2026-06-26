
public class TrailingZero {
	
	public static void main(String args[]) {
		int a[] = {1,1,0,0,0};
//		System.out.print(a);
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]!=0 && a[j]==0) {
					int temp=0;
					temp =a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+",");
		}
	}

}
