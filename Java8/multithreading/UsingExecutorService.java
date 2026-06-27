package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Counter{
	int count =0;
	 void increment() {
		 //synchronized block
		 synchronized(this) {
			 	count++;
			 	}
	}
	 int getCount() {
		 return count;
	 }
}
public class UsingExecutorService {

	public static void main(String args[]) throws InterruptedException {
		
		ExecutorService ex = Executors.newFixedThreadPool(3);
		Counter counter = new Counter();
		
		for(int i=0;i<10;i++) {
			ex.submit(()->{
				counter.increment();
			});
		}
		
		ex.shutdown(); // Finish all the existing task and dont accept new task/
		ex.awaitTermination(1, TimeUnit.MINUTES); // wait for 1 minute till the tasks complete.
		
		System.out.println(counter.getCount());
		
	}
}
