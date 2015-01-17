/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.business;

import java.util.List;
import javax.ejb.Stateless;
import rs.fit.dao.IVozilo;
import rs.fit.dao.VoziloImpl;
import rs.fit.entities.Vozilo;

/**
 *
 * @author Milan
 */
@Stateless
public class BusinessSB implements BusinessSBLocal {

    /**
     * Metoda koja vraca sva vozila iz baze
     * @return 
     */
    @Override
    public List<Vozilo> getAll() {
        IVozilo voziloDao = new VoziloImpl();
        return voziloDao.getAll();
    }

    /**
     * Metoda koja unosi novo vozilo u bazu
     * @param marka
     * @param model
     * @param godiste
     * @param gorivo 
     */
    @Override
    public void createVozilo(String marka, String model, int godiste, float gorivo) {
        IVozilo voziloDao = new VoziloImpl();
        voziloDao.add(marka, model, godiste, gorivo);
    }

    /**
     * Metoda koja brise vozilo sa prosledjenim id-jem (objektom)
     * @param vozilo 
     */
    @Override
    public void deleteVozilo(int vozilo) {
        IVozilo voziloDao = new VoziloImpl();
        voziloDao.remove(vozilo);
    }

    /**
     * Metoda koja pretrazuje vozila na osnovu godista
     * @param godiste
     * @return lista vozila
     */
    @Override
    public List<Vozilo> findGodVozila(int godiste) {
        IVozilo voziloDao = new VoziloImpl();
        return voziloDao.findGodiste(godiste);
    }

    /**
     * Metoda koja pretrazuje vozina na osnovu modela
     * @param model
     * @return 
     */
    @Override
    public List<Vozilo> findModelVozila(String model) {
        IVozilo voziloDao = new VoziloImpl();
        return voziloDao.findModel(model);
    }

    
}
