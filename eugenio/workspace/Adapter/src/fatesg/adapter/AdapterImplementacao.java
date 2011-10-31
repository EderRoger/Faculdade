package fatesg.adapter;

public class AdapterImplementacao implements Adapter {

	@Override
	public double calculaRaiz(double valor) {
		return Math.sqrt(valor);
	}

	@Override
	public double potencia(int base, int expoente) {
		return Math.pow(base, expoente);
	}

}
