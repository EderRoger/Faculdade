package fatesg.singleton;

import fatesg.singleton.exception.CaldeiraException;

public class Caldeira {

	public static int quantidadeCaldeira = 0;
	private int nivelAgua;
	private int temperaturaAgua;
	private static Caldeira instancia = null;

	private Caldeira() {

	}

	public static Caldeira getCaldeira() throws CaldeiraException {
		if (instancia == null) {
			instancia = new Caldeira();
			return instancia;
		} else {
			throw new CaldeiraException("Caldeira ja criada");
		}
	}

	public static int getQuantidadeCaldeira() {
		return quantidadeCaldeira;
	}

	public static void setQuantidadeCaldeira(int quantidadeCaldeira) {
		Caldeira.quantidadeCaldeira = quantidadeCaldeira;
	}

	public int getNivelAgua() {
		return nivelAgua;
	}

	public void setNivelAgua(int nivelAgua) {
		this.nivelAgua = nivelAgua;
	}

	public int getTemperaturaAgua() {
		return temperaturaAgua;
	}

	public void setTemperaturaAgua(int temperaturaAgua) {
		this.temperaturaAgua = temperaturaAgua;
	}

}
