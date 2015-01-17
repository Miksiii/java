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

/**
 *
 * @author Milan
 */
public interface IKartaDAO {
    public List<Karta> getKartList(Korisnik korisnik);
    public void addKarta(Korisnik korisnikId, int mesto, String status, String napomena, BigDecimal cena);
}
