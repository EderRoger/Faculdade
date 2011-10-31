/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testcase;

import execao.ValorMaximoInvalidoException;
import junit.framework.TestCase;
import teste.GeradorPrimos;

/**
 *
 * @author aluno
 */
public class GeradorPrimosTeste extends TestCase {

    GeradorPrimos geradorPrimos = new GeradorPrimos();

    public void testePrimosGeradosAteNumeroDois() throws Exception {
        verificaPrimosGerados("2", 2);
    }

    public void testePrimosGeradosAteNumeroTres() throws Exception {
        verificaPrimosGerados("2, 3", 3);
    }

    public void testePrimosGeradosAteNumeroQuatro() throws Exception {
        verificaPrimosGerados("2, 3", 4);
    }

    public void testePrimosGeradosAteNumeroCinco() throws Exception {
        verificaPrimosGerados("2, 3, 5", 5);
    }

    public void testeSeRejeitaValorMaximoUm() throws Exception {
        verificaSeRejeitaNumerosMenoresQueDois(1);
    }

    public void testeSeRejeitaValorMaximoZero() throws Exception {
        verificaSeRejeitaNumerosMenoresQueDois(0);
    }

    public void testeSeRejeitaValorMaximoNegativo() throws Exception {
        verificaSeRejeitaNumerosMenoresQueDois(-1);
    }

    public void testePrimosGeradosAteNumeroDez() throws Exception {
        verificaPrimosGerados("2, 3, 5, 7", 10);
    }

    public void testePrimosGeradosAteNumeroVinteDois() throws Exception {
        verificaPrimosGerados("2, 3, 5, 7, 11, 13, 17, 19", 22);
    }

    //public void testeInicializadorDeListaDeCandidatos() {
    //  int valorMaximo = 5;
    // boolean[] candidatos = geradorPrimos.inicializaListaDePrimosPotenciais(valorMaximo);
    // verificaSeCandidatoTemValorEsperado(0, false, candidatos[0]);
    // verificaSeCandidatoTemValorEsperado(1, false, candidatos[1]);
    // for (int i = GeradorPrimos.MENOR_PRIMO; i <= valorMaximo; i++) {
    //    verificaSeCandidatoTemValorEsperado(i, true, candidatos[i]);
    // }
    //}
    public void testInicializacaoListaDePrimosPotenciais() throws Exception {
        int valorMaximo = 5;
        boolean[] ehPrimo =
                geradorPrimos.inicializaListaDePrimosPotenciais(valorMaximo);
        verificaSeEhPrimo(0, false, ehPrimo[0]);
        verificaSeEhPrimo(1, false, ehPrimo[1]);
        for (int i = GeradorPrimos.MENOR_PRIMO; i <= valorMaximo; i++) {
            verificaSeEhPrimo(i, true, ehPrimo[i]);
        }
    }

    private void verificaSeEhPrimo(int i, boolean esperado, boolean numero) {
        assertEquals("ehPrimo[" + i + "]:", esperado, numero);
    }

    // private void verificaSeCandidatoTemValorEsperado(int i, boolean valorEsperado, boolean candidato) {
    //   assertEquals("candidatos[" + i + "];", valorEsperado, candidato);
    // }
    private void verificaSeRejeitaNumerosMenoresQueDois(int valorMaximo) {
        try {
            geradorPrimos.gerarPrimosAte(valorMaximo);
            fail("Deveria ter lançado ValorMaximoInvalidoException");
        } catch (ValorMaximoInvalidoException e) {
            assertTrue(true);
        }
    }

    private void verificaPrimosGerados(String listaEsperada, int numeroMaximo) throws Exception {
        assertEquals(listaEsperada, geradorPrimos.gerarPrimosAte(numeroMaximo));
    }
}
