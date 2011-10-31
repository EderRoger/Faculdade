/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author daniel
 */

import java.rmi.registry.*;
import servidor.*;

public class MainCliente 
{
    public static void main(String[] args) 
    {
        try{
        Registry registro = LocateRegistry.getRegistry("localhost");
        CalculadoraServerInterface c = (CalculadoraServerInterface) registro.lookup("CalculadoraServerInterfaceImpl");
        System.out.println("O objeto " +c+ "foi localizado com sucesso!\n\n" );
        System.out.println("Calculadora Remota: SOMA: " + c.soma(5, 2));
        }
        catch(Exception e){
            
        }
    }
}
