package fatesg.singleton.principal;

import java.util.Random;

import fatesg.singleton.Caldeira;
import fatesg.singleton.entidade.Usuario;
import fatesg.singleton.enumerador.NivelAgua;
import fatesg.singleton.enumerador.NivelGas;
import fatesg.singleton.enumerador.TemperaturaAgua;
import fatesg.singleton.enumerador.TipoControle;
import fatesg.singleton.exception.CaldeiraException;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// criando a caldeira..
			Caldeira caldeira = Caldeira.getCaldeira();
			caldeira.setNivelAgua(NivelAgua.ACEITAVEL.getValorNivel());
			caldeira.setTemperaturaAgua(TemperaturaAgua.ACEITAVEL.getValorTemperatura());

			Usuario usuarioControlaAgua = new Usuario();
			usuarioControlaAgua.setNome("Eder");

			Usuario usuarioControlaTemperatura = new Usuario();
			usuarioControlaTemperatura.setNome("Cleomar");

			// criando o controle agua e temperatura...
			Controle controleCaldeiraAgua = new Controle();
			controleCaldeiraAgua.setTipoControle(TipoControle.AGUA);
			controleCaldeiraAgua.setUsuario(usuarioControlaAgua);
			controleCaldeiraAgua.setCaldeira(caldeira);

			Controle controleCaldeiraTemperatura = new Controle();
			controleCaldeiraTemperatura.setTipoControle(TipoControle.TEMPERATURA);
			controleCaldeiraTemperatura.setUsuario(usuarioControlaTemperatura);
			controleCaldeiraTemperatura.setCaldeira(caldeira);

			int cont = 0;
			Random randon = new Random();
			while (cont++ < 10) {

				//simulando alteracoes
				caldeira.setNivelAgua(randon.nextInt(130));
				caldeira.setTemperaturaAgua(randon.nextInt(100));
				
				controleCaldeiraAgua.aumentarEmissaoDeGas(NivelGas.AUMENTA);
				System.out.println("*******************************************************************************");
				System.out.println("AGUA: " + controleCaldeiraAgua.verificarNivelDaAgua(caldeira).getDescricao());
				System.out.println("controle de agua: nivel de agua: " + controleCaldeiraAgua.getCaldeira().getNivelAgua());
				System.out.println("controle de temperatura: nivel de agua: " + controleCaldeiraTemperatura.getCaldeira().getNivelAgua());
				System.out.println();
				System.out.println("TEMPERATURA: " + controleCaldeiraTemperatura.verificarTemperaturaDaAgua(caldeira).getDescricao());
				System.out.println("controle de agua: nivel de temperatura: " + controleCaldeiraAgua.getCaldeira().getTemperaturaAgua());
				System.out.println("controle de temperatura: nivel de temperatura: " + controleCaldeiraTemperatura.getCaldeira().getTemperaturaAgua());
			}

		} catch (CaldeiraException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
