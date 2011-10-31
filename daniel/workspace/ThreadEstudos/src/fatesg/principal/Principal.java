package fatesg.principal;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		MinhaThread thread = new MinhaThread();

		Thread t1 = new Thread(thread);
		t1.setName("Thread 1");
		Thread t2 = new Thread(thread);
		t2.setName("Thread 2");
		Thread t3 = new Thread(thread);
		t3.setName("Thread 3");
		Thread t4 = new Thread(thread);
		t4.setName("Thread 4");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}
}
