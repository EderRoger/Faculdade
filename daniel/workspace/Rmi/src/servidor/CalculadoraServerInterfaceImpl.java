/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author daniel
 */
import java.rmi.*;

public class CalculadoraServerInterfaceImpl extends UnicastRemoteObject 
implements   CalculadoraServerInterface
    {
    public CalculadoraServerInterfaceImpl()throws RemoteException
    {super();
    }
    @Override
        public int soma(int op1, int op2) throws RemoteException
        {
            return op1+op2;
        }
    }
