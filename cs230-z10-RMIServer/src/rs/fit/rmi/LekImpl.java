/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa LekImpl implementira interfejs ILek
 * @author Milan
 */
public class LekImpl extends UnicastRemoteObject implements ILek{
    
    /* lista koja prima niz stringova (naziv, doza i ime proizvodjaca */
    private List<String[]> listaLekova = new ArrayList<String[]>();
    
    /**
     * Konstruktor koji baca RemoteException
     * @throws RemoteException 
     */
    public LekImpl() throws RemoteException {
        System.out.println("Inicijalizacija implementacije Interfejsa ILek..");
    }

    /**
     * Metoda koja prima parametre koji predstavljaju podatke o leku,  setuje
     * vrednosti konkretnog podatka i ubacuje ga u listu lekova
     * @param naziv
     * @param doza
     * @param proizvodjacIme 
     */
    @Override
    public void add(String naziv, String doza, String proizvodjacIme) {
        String[] konkretniPodatak = new String[3];
        
        konkretniPodatak[0] = naziv;
        konkretniPodatak[1] = doza;
        konkretniPodatak[2] = proizvodjacIme;
        
        listaLekova.add(konkretniPodatak);
    }

    /**
     * Metoda koja vraca listu svih podataka o lekovima
     * @return listaLekova
     */
    @Override
    public List<String[]> fetchAll() {
        return listaLekova;
    }
    
}
