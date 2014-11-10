/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Milan
 */
public class RegistracijaRMI {

    /**
     * Konstruktor u kome se vrsi registracija objekta u RMI registar
     * @throws RemoteException
     * @throws AlreadyBoundException 
     */
    public RegistracijaRMI() throws RemoteException, AlreadyBoundException {
        /* instanciranje implementacija interfejsa */
        ILek lekObj = new LekImpl();
        /* pozivanje i kreiranje RMI registra */
        Registry registar = LocateRegistry.createRegistry(2099);
        /* dodavanje objekta zajedno sa svim njegovim metodama u RMI registar */
        registar.bind("lekObj", lekObj);
        
        System.out.println("Objekat lek je uspesno registrovan");
    }
    
    /**
     * Pokretacka metoda
     * @param args
     * @throws AlreadyBoundException
     * @throws RemoteException 
     */
    public static void main(String[] args) throws AlreadyBoundException, RemoteException {
        new RegistracijaRMI();
    }
}
