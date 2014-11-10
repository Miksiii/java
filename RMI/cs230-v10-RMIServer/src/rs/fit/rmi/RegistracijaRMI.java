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

    public RegistracijaRMI() throws RemoteException, AlreadyBoundException {
        
        /* instanciranje implementacija interfejsa */
        IStudentServer objekat = new StudentServerImpl();
        /* pozivanje RMI registra */
        Registry registar = LocateRegistry.createRegistry(2099);
        /* dodavanje objekta zajedno sa svim njegovim metodama u RMI registar */
        registar.bind("studentObj", objekat);
        /* console log */
        System.out.println("Student server " + objekat + " je registrovan u RMI registru");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        new RegistracijaRMI();
    }
    
}
