package multithreading;

class MyThread1 implements Runnable{
	
	@Override
	public void run() {
		System.out.println("Runnig thread with Runnable");
	}
	
}

public class ThreadUsingRunnable {
	public static void main(String args[]) {
		 MyThread1 t = new MyThread1();
		 Thread th = new Thread(t);
		 th.start();
		
	 }
}
