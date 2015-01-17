/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import rs.fit.entities.Vozilo;

/**
 *
 * @author Milan
 */
public class VoziloImpl implements IVozilo {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs230-z06-vozila-ejbPU");
    private EntityManager manager  = emf.createEntityManager();
    private List<Vozilo> vozila = new ArrayList<>();
    private List<Vozilo> vozilaByGodiste = new ArrayList<>();
    private List<Vozilo> vozilaByModel   = new ArrayList<>();
    
    /**
     * DAO GET ALL
     * @return 
     */
    @Override
    public List<Vozilo> getAll() {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        vozila = manager.createNamedQuery("Vozilo.findAll", Vozilo.class).
                       getResultList();
        
        manager.close();
        emf.close();
        
        return vozila;
    }

    /**
     * DAO ADD NEW
     * @param marka
     * @param model
     * @param godiste
     * @param gorivo 
     */
    @Override
    public void add(String marka, String model, int godiste, float gorivo) {
        try {
        Vozilo newVozilo = new Vozilo();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        newVozilo.setVoziloMarka(marka);
        newVozilo.setVoziloModel(model);
        newVozilo.setVoziloGodiste(godiste);
        newVozilo.setVoziloGorivo(gorivo);
        
        manager.persist(newVozilo);
        
        tx.commit();
        emf.close();
        } catch (Exception e) {
            System.out.println("Error pri upisu u bazu");
        }
    }

    /**
     * DELETE SPECIFIC
     * @param vozilo 
     */
    @Override
    public void remove(int vozilo) {
        Vozilo voziloToDel = null;
                
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        voziloToDel = manager.createNamedQuery("Vozilo.findByReference", Vozilo.class).
                setParameter("voziloRef", vozilo).
                getSingleResult();
        
        manager.remove(voziloToDel);
        tx.commit();
        manager.close();
        emf.close();   
    }

    /**
     * FIND SPECIFIC
     * @param godiste
     * @return 
     */
    @Override
    public List<Vozilo> findGodiste(int godiste) {        
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        vozilaByGodiste = manager.createNamedQuery("Vozilo.findByVoziloGodiste", Vozilo.class).
                       setParameter("voziloGodiste", godiste).
                       getResultList();
        
        manager.close();
        emf.close();
        
        return vozilaByGodiste;
    }

    /**
     * FIND SPECIFIC
     * @param model
     * @return 
     */
    @Override
    public List<Vozilo> findModel(String model) {
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        vozilaByModel = manager.createNamedQuery("Vozilo.findByVoziloModel", Vozilo.class).
                       setParameter("voziloModel", model).
                       getResultList();
        
        manager.close();
        emf.close();
        
        return vozilaByModel;
    }
    
}
