/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.dao;

import com.cs230.entities.Bend;
import com.cs230.entities.Karta;
import com.cs230.entities.Koncert;
import com.cs230.entities.Korisnik;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Milan
 */
public class KoncertImpl implements IKoncertDAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs230-z05-koncertJPAPU");
    private EntityManager manager    = emf.createEntityManager();
    private List koncerti = new ArrayList<Koncert>();
    
    /**
     * Vraca listu aktuelnih koncerata
     * @return 
     */
    @Override
    public List<Koncert> getList() {
        
        System.out.println(" ***** Setting up and connecting to the database... ***** ");
        System.out.println(" ***** Starting transaction... ***** ");
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        koncerti = manager.createNamedQuery("Koncert.findActual", Koncert.class).
                       getResultList();
        
        for (Object konc : koncerti) {
            manager.persist(konc);
        }
        
        /* functional stream
        koncerti.stream().forEach((konc) -> {
            manager.persist(konc);
        });
        */
        
        System.out.println("Commiting, closing manager, closing emf");
        System.out.println(" ************************************ ");
        tx.commit();
        manager.close();
        emf.close();
        
        return koncerti;
    }
    
}
