package fatesg.singleton.enumerador;

public enum NivelAgua {

	NIVEL_INSUFICIENTE(0, "INSUFICIENTE"), MINIMO(33, "MINIMO"), ACEITAVEL(66, "ACEITAVEL"), MAXIMO(100, "MAXIMO"), PERIGO(1000, "PERIGO");

	private int valorNivel;
	private String descricao;

	NivelAgua(int nivel, String desc) {
		this.valorNivel = nivel;
		this.descricao = desc;
	}

	public int getValorNivel() {
		return valorNivel;
	}

	public String getDescricao() {
		return descricao;
	}

}
