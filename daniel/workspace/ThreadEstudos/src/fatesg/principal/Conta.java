package fatesg.principal;

public class Conta {

	private double saldo = 50;

	public double verificarSaldo() {
		return saldo;
	}

	public void retirada(double valor) {
		this.saldo -= valor;
	}
	
	
}
