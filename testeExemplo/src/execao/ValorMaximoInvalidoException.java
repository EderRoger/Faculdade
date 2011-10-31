/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package execao;

/**
 *
 * @author aluno
 */
public class ValorMaximoInvalidoException extends Exception {

    public ValorMaximoInvalidoException() {
        super("O valor maximo deve ser maior ou igual a 2");
    }

}
