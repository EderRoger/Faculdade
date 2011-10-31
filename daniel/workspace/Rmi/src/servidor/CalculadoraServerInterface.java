/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

/**
 *
 * @author daniel
 */
import java.rmi.*;

public interface CalculadoraServerInterface extends Remote
{
    public int soma(int op1, int op2) throws RemoteException;
    
}
