package fatesg.singleton.enumerador;

public enum TemperaturaAgua {

	ABAIXO_MINIMO(0, "ABAIXO MINIMO"), MINIMA(30, "MINIMO"), MAXIMA(90, "MAXIMO"), ACEITAVEL(60, "ACEITAVEL"), ACIMA_MAXIMO(100, "ACIMA MAXIMO");

	private int valorTemperatura;
	private String descricao;

	TemperaturaAgua(int temperatura, String desc) {
		this.valorTemperatura = temperatura;
		this.descricao = desc;
	}

	public int getValorTemperatura() {
		return valorTemperatura;
	}

	public String getDescricao() {
		return descricao;
	}

}
