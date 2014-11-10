/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Klijentski interfejs koji predstavlja udaljeni RMI interfejs koji pruza pristup 
 * dveju metodama
 * @author Milan
 */
public interface ILek extends Remote {
    public void add(String naziv, String doza, String proizvodjacIme) throws RemoteException;
    public List<String[]> fetchAll() throws RemoteException;
}