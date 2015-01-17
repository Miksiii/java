/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.dao;

import com.cs230.entities.Karta;
import com.cs230.entities.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Milan
 */
public class KorisnikImpl implements IKorisnikDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs230-z05-koncertJPAPU");
    private EntityManager manager    = emf.createEntityManager();
   
    /**
     * Metoda koja na osnovu unetih parametara vraca konkretnog korisnika
     * @param username
     * @param password
     * @return 
     */
    @Override
    public Korisnik getKorisnik(String username, String password) {
        Korisnik korisnik = null;
        System.out.println(" ***** Setting up and connecting to the database... ***** ");
        System.out.println(" ***** Starting transaction... ***** ");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        korisnik = manager.createNamedQuery("Korisnik.findByUserAndPass", Korisnik.class).
                       setParameter("koriUsername", username).
                       setParameter("koriPassword", password).
                       getSingleResult(); 
        
        manager.persist(korisnik);
        
        System.out.println("Commiting, closing manager, closing emf");
        tx.commit();
        manager.close();
        emf.close();
        
        return korisnik;
    }

    @Override
    public void addKorisnik(String username, String password, String address, String rola, String telefon) {
        try {
            Korisnik korisnik = new Korisnik();
            System.out.println(" ***** Setting up and connecting to the database... ***** ");
            System.out.println(" ***** Starting transaction... ***** ");
            EntityTransaction tx = manager.getTransaction();
            tx.begin();

            korisnik.setKoriUsername(username);
            korisnik.setKoriPassword(password);
            korisnik.setKoriAdresa(address);
            korisnik.setKoriRola(rola);
            korisnik.setKoriTelefon(telefon);
            manager.persist(korisnik);

            System.out.println("Commiting, closing manager, closing emf");
            tx.commit();
            manager.close();
            emf.close();
        } catch(Exception e) {
            System.out.println("Error while inserting Korisnik into the database: " + e.getMessage());
        }
    }
}
