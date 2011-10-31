package fatesg.principal;

public class ClienteBanco implements Runnable {

	private Conta conta = new Conta();

	public static void main(String[] args) {

		ClienteBanco banco = new ClienteBanco();
		Thread cliente1 = new Thread(banco);
		cliente1.setName("Eder");
		Thread cliente2 = new Thread(banco);
		cliente2.setName("Joaquin");

		cliente1.start();
		cliente2.start();

	}

	@Override
	public void run() {
		for (int x = 0; x < 5; x++) {
			efetuarSaque(10);
			if (conta.verificarSaldo() < 0) {
				System.out.println("Conta sem saldo");
			}
		}
	}

	private  void efetuarSaque(double valor) {
		if (conta.verificarSaldo() >= valor) {
			System.out.println(Thread.currentThread().getName()
					+ " Esta sacando dinheiro....");

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
			conta.retirada(valor);
			System.out.println(Thread.currentThread().getName()
					+ " Completou a retirada " + valor);

		} else {
			System.out.println(Thread.currentThread().getName()
					+ " Saldo insuficiente para saque.... saldo atual: "
					+ conta.verificarSaldo());

		}
	}

}
