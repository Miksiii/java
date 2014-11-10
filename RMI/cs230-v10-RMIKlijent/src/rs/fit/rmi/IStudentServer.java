package rs.fit.rmi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Milan
 */
public interface IStudentServer extends Remote{
    public double pronadjiRezultat(String ime) throws RemoteException;
}
