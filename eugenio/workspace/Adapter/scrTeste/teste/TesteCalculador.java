package teste;

import main.Calculador;
import junit.framework.TestCase;

public class TesteCalculador extends TestCase {

	Calculador calculador = new Calculador();

	public void testeCalculoDeRaiz() {
		assertEquals("experado 2",2, (int) calculador.calcularRaiz(4));
	}

	public void testeCalculoDePotencia() {
		assertEquals("experado 100",101, (int) calculador.calcularPotencia(10, 2));
	}
}