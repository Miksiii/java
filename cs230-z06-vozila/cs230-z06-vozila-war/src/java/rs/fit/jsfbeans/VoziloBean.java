/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.jsfbeans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import rs.fit.business.BusinessSBLocal;
import rs.fit.entities.Vozilo;

/**
 *
 * @author Milan
 */
@ManagedBean
@RequestScoped
public class VoziloBean {
    @EJB
    private BusinessSBLocal businessSB;
    private String marka;
    private String model;
    private int godiste;
    private Float gorivo;
    
    public VoziloBean() {
    }

    public BusinessSBLocal getBusinessSB() {
        return businessSB;
    }

    public void setBusinessSB(BusinessSBLocal businessSB) {
        this.businessSB = businessSB;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public Float getGorivo() {
        return gorivo;
    }

    public void setGorivo(Float gorivo) {
        this.gorivo = gorivo;
    }
    
    /**
     * Vraca listu svih vozila
     * @return vozila
     */
    public List<Vozilo> getAll() {
        return businessSB.getAll();
    }
    
    /**
     * Metoda koja se poziva prilikom sabmitovanja forme za unos vozila
     * @return String
     */
    public String getUnosResponse() {
        if(marka != null && model != null && godiste != 0 && gorivo != null) {
            businessSB.createVozilo(marka, model, godiste, gorivo);
            return "Vozilo uspesno uneto";
        } else { 
            return null;
        }
    }
    
    /**
     * Metoda koja brise vozilo iz liste
     * @param vozilo 
     */
    public void deleteVozilo(int vozilo) {
        businessSB.deleteVozilo(vozilo);
    }
    
    /**
     * Metoda koja vraca listu sa godistima koje se koristi za formu pretrage
     * @return integers
     */
    public List<Integer> selectGodiste() {
        List<Integer> godista = new ArrayList<>();
        
        for(Vozilo vozilo : businessSB.getAll()) {
            if(!godista.contains(vozilo.getVoziloGodiste())) {
                godista.add(vozilo.getVoziloGodiste());
            }
        }
        
        return godista;
    }
    
    /**
     * Metoda koja salje zahtev za pretragu po godistu
     */
    public void pretragaGodisteRequest() {
        businessSB.findGodVozila(godiste);
    }
    
    /**
     * Metoda koja salje zahtev za pretragu po modelu
     */
    public void pretragaModelRequest() {
        businessSB.findModelVozila(model);
    }
    
    /**
     * Metoda koja vraca listu pronadjenih vozila po godistu
     * @return vozila 
     */
    public List<Vozilo> getByGodiste() {
        return businessSB.findGodVozila(godiste);
    }
    
    /**
     * Metoda koja vraca listu pronadjenih vozila po modelu
     * @return vozila 
     */
    public List<Vozilo> getByModel() {
        return businessSB.findModelVozila(model);
    }
}
