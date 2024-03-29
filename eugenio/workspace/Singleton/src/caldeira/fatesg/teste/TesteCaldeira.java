package caldeira.fatesg.teste;

import junit.framework.TestCase;

import org.junit.Assert;

import fatesg.singleton.Caldeira;
import fatesg.singleton.enumerador.NivelAgua;
import fatesg.singleton.enumerador.TemperaturaAgua;
import fatesg.singleton.exception.CaldeiraException;

public class TesteCaldeira extends TestCase {

	Caldeira caldeira;

	public void testeNivelDaAgua() {
		try {
			caldeira = Caldeira.getCaldeira();
			caldeira.setNivelAgua(NivelAgua.ACEITAVEL.getValorNivel());
			Assert.assertEquals(NivelAgua.ACEITAVEL.getValorNivel(), caldeira.getNivelAgua());
		} catch (CaldeiraException e) {
			assertTrue("lancou caldeira exception : caldeira ja criada",true);
		}
	}

	public void testeNivelDaTemperatura() {
		try {
			caldeira = Caldeira.getCaldeira();
			caldeira.setTemperaturaAgua(TemperaturaAgua.ACEITAVEL.getValorTemperatura());
			Assert.assertEquals(TemperaturaAgua.ACIMA_MAXIMO.getValorTemperatura(), caldeira.getTemperaturaAgua());
		} catch (CaldeiraException e) {
			assertTrue("lancou caldeira exception : caldeira ja criada",true);
		}
	}

}
