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


public interface IKorisnikDAO {
    public Korisnik getKorisnik(String username, String password);
    public void addKorisnik(String username, String password, String address, String rola, String telefon);
}
