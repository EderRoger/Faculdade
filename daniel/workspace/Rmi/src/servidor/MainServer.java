/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.rmi.registry.Registry;

/**
 *
 * @author daniel
 */


public class MainServer 
{
    public static void main(String[] args) 
    {
        try{
            CalculadoraServerInterface x = new CalculadoraServerInterfaceImpl();
            Registry registro = java.rmi.registry.LocateRegistry.createRegistry(1099);//LocateRegistry.getRegistry();
            
            registro.rebind("CalculadoraServerInterfaceImpl", x);
        }
        catch (Exception e){
            System.out.println("Erro:" + e.getMessage());
        }
    }
}
