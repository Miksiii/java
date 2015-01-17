/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.business;

import java.util.List;
import javax.ejb.Local;
import rs.fit.entities.Vozilo;

/**
 *
 * @author Milan
 */
@Local
public interface BusinessSBLocal {
    List<Vozilo> getAll();
    void createVozilo(String marka, String model, int godiste, float gorivo);
    void deleteVozilo(int vozilo);
    List<Vozilo> findGodVozila(int godiste);
    List<Vozilo> findModelVozila(String model);
}
