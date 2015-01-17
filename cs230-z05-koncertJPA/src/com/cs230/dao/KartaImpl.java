/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cs230.dao;

import com.cs230.entities.Karta;
import com.cs230.entities.Korisnik;
import java.math.BigDecimal;
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
public class KartaImpl implements IKartaDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs230-z05-koncertJPAPU");
    private EntityManager manager    = emf.createEntityManager();
    private List karte = new ArrayList<Karta>();

    /**
     * Metoda koja prima objekat tipa korisnik preko koga namequery uzima njegov
     * id i na osnovu njega vraca listu karata koje postoje za korisnika sa tim 
     * identifikacionim brojem
     * @param korisnik
     * @return 
     */
    @Override
    public List<Karta> getKartList(Korisnik korisnik) {

        System.out.println(" ***** Setting up and connecting to the database... ***** ");
        System.out.println(" ***** Starting transaction... ***** ");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        karte = manager.createNamedQuery("Karta.getKartByKoriId", Karta.class).
                       setParameter("koriId", korisnik).
                       getResultList(); 
        
        for(Object obj : karte) {
            manager.persist(obj);
        }
        
        System.out.println("Commiting, closing manager, closing emf");
        tx.commit();
        manager.close();
        emf.close();
        
        return karte;
    }

    @Override
    public void addKarta(Korisnik korisnikId, int mesto, String status, String napomena, BigDecimal cena) {
        try {
            Karta kart = new Karta();
            System.out.println(" ***** Setting up and connecting to the database... ***** ");
            System.out.println(" ***** Starting transaction... ***** ");
            EntityTransaction tx = manager.getTransaction();
            tx.begin();

            kart.setKoriId(korisnikId);
            kart.setKartMesto(mesto);
            kart.setKartStatus(status);
            kart.setKartNapomena(napomena);
            kart.setKartCena(cena);
            manager.persist(kart);

            System.out.println("Commiting, closing manager, closing emf");
            tx.commit();
            manager.close();
            emf.close();
        } catch(Exception e) {
            System.out.println("Error while inserting Korisnik into the database: " + e.getMessage());
        }
    }
    
    
}
