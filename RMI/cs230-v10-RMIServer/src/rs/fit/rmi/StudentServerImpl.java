/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

/**
 *
 * @author Milan
 */
public class StudentServerImpl extends UnicastRemoteObject implements IStudentServer {

    private HashMap<String, Double> studentDB = new HashMap<>();
    
    public StudentServerImpl() throws RemoteException {
        inicijalizacija();
    }
    
    /**
     * Metoda koja popunjava hash mapu sa nekim podacima ponasajuci se kao baza
     */
    public void inicijalizacija() {
        studentDB.put("hakaj", 25.00);
        studentDB.put("rodic", 22.00);
        studentDB.put("stojkovic", 23.00);
        studentDB.put("vasic", 25.00);
    }
    
    /**
     * Metoda koja na osnovu prosledjenog parametra pronalazi odredjenog studenta
     * i njegov rezultat vraca nazad. Ovo je metoda udaljenog poziva koji je pozvan
     * od strane klijenta kada je to potrebno. 
     * @param ime
     * @return 
     */
    @Override
    public double pronadjiRezultat(String ime) {
        Double rezultat = studentDB.get(ime);
        
        if(rezultat == null) {
            System.out.println("Student sa imenom '" + ime + "' nije pronadjen u hash mapi.");
            return -1;
        } else {
            System.out.println("Student sa imenom '" + ime + "' ima '" + rezultat + "' poena");
            return rezultat;
        }
    }
}
