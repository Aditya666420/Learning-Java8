package multithreading;



class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Runnig thread");
	}
	
}
public class ThreadUsingThreadClass {
 public static void main(String args[]) {
	 MyThread t = new MyThread();
	 t.start();
 }
}
