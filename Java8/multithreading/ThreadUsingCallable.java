package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread2 implements Callable<String>{
	
	@Override
	public String call() {
		return "Running using callable";
	}

	
	
}


public class ThreadUsingCallable {
	
	public static void main(String args[]) {
		Callable<String> cl = new MyThread2();
		FutureTask<String> ft = new FutureTask<>(cl); // converting callable to runnable
		Thread t = new Thread(ft);
		t.start();
		try {
			System.out.println(ft.get());  // ft.get() is done as call() method is of string type and its returning a string.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
