package fatesg.singleton.principal;

import fatesg.singleton.Caldeira;
import fatesg.singleton.entidade.Usuario;
import fatesg.singleton.enumerador.NivelAgua;
import fatesg.singleton.enumerador.NivelGas;
import fatesg.singleton.enumerador.TemperaturaAgua;
import fatesg.singleton.enumerador.TipoControle;

public class Controle {

	private Usuario usuario;
	private TipoControle tipoControle;
	private Caldeira caldeira;

	public void aumentarEmissaoDeGas(NivelGas gas) {
		if (gas == NivelGas.AUMENTA) {
			caldeira.setNivelAgua(caldeira.getNivelAgua() - 30);
			caldeira.setTemperaturaAgua(caldeira.getTemperaturaAgua() + 30);
		}

	}

	public NivelAgua verificarNivelDaAgua(Caldeira caldeira) {
		if (caldeira.getNivelAgua() < NivelAgua.MINIMO.getValorNivel()) {
			return NivelAgua.NIVEL_INSUFICIENTE;
		}
		if (caldeira.getNivelAgua() > NivelAgua.MINIMO.getValorNivel() && caldeira.getNivelAgua() < NivelAgua.MAXIMO.getValorNivel()) {
			return NivelAgua.ACEITAVEL;
		}
		if (caldeira.getNivelAgua() > NivelAgua.MAXIMO.getValorNivel()) {
			return NivelAgua.PERIGO;
		}
		return (caldeira.getNivelAgua() == NivelAgua.MAXIMO.getValorNivel()) ? NivelAgua.MAXIMO : NivelAgua.MINIMO;
	}

	public TemperaturaAgua verificarTemperaturaDaAgua(Caldeira caldeira) {
		if (caldeira.getTemperaturaAgua() < TemperaturaAgua.MINIMA.getValorTemperatura()) {
			return TemperaturaAgua.ABAIXO_MINIMO;
		}
		if (caldeira.getTemperaturaAgua() > TemperaturaAgua.MINIMA.getValorTemperatura()
				&& caldeira.getTemperaturaAgua() < TemperaturaAgua.MAXIMA.getValorTemperatura()) {
			return TemperaturaAgua.ACEITAVEL;
		}
		if (caldeira.getTemperaturaAgua() > TemperaturaAgua.MAXIMA.getValorTemperatura()) {
			return TemperaturaAgua.ACIMA_MAXIMO;
		}
		return (caldeira.getTemperaturaAgua() == TemperaturaAgua.MAXIMA.getValorTemperatura()) ? TemperaturaAgua.MAXIMA : TemperaturaAgua.MINIMA;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoControle getTipoControle() {
		return tipoControle;
	}

	public void setTipoControle(TipoControle tipoControle) {
		this.tipoControle = tipoControle;
	}

	public Caldeira getCaldeira() {
		return caldeira;
	}

	public void setCaldeira(Caldeira caldeira) {
		this.caldeira = caldeira;
	}

}
