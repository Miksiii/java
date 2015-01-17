/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.dao;

import java.util.List;
import rs.fit.entities.Vozilo;

/**
 *
 * @author Milan
 */
public interface IVozilo {
    List<Vozilo> getAll();
    void add(String marka, String model, int godiste, float gorivo);
    void remove(int vozilo);
    List<Vozilo> findGodiste(int godiste);
    List<Vozilo> findModel(String model);
}
