package fatesg.principal;

public class MinhaThread implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Iniciei: " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);//sllep one seconddd..
			} catch (InterruptedException ex) {
			}
		}

	}

}
