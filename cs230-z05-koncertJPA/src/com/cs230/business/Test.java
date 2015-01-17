/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.business;

import com.cs230.dao.IKartaDAO;
import com.cs230.dao.IKoncertDAO;
import com.cs230.dao.IKorisnikDAO;
import com.cs230.dao.KartaImpl;
import com.cs230.dao.KoncertImpl;
import com.cs230.dao.KorisnikImpl;
import com.cs230.entities.Bend;
import com.cs230.entities.Karta;
import com.cs230.entities.Koncert;
import com.cs230.entities.Korisnik;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Milan
 */
public class Test {
    
    public static void main(String[] args) throws ParseException{
        
        IKorisnikDAO korisnikDao = new KorisnikImpl();
        IKoncertDAO  koncertDao = new KoncertImpl();
        IKartaDAO    kartaDao = new KartaImpl();
        
        /*
        Metod koji dodaje novog korisnika
        korisnikDao.addKorisnik("Katarina", "Kaplarski", "Tadeusa Koscuska", "rola ketty", "0613523532");
        */
        
        /*
        Metod koji dodaje kovu kartu
        kartaDao.addKarta(korisnikDao.getKorisnik("miksi", "sneletron123"), 125, "Karta novi status", "Karta nova napomena", new BigDecimal(21.24, MathContext.DECIMAL64));
        */
        
        /*
        Na osnovu unetog username i pass-a vraca konkretnog korisnika (objekat).
        Metode kojima mozemo pristupiti su:
        -getKoriUsername
        -getKoriPassword
        -getKoriAdresa
        -getKoriRola
        -getKoriTelefon
        */
        //System.out.println("Broj telefona korisnika: " + korisnikDao.getKorisnik("miksi", "sneletron123").getKoriTelefon());

              
        /*
        Prosledjivanje korisnika u metodu getKartList na osnovu cega se izdvajaju
        karte koje poseduje specificni korisnik
        */
        //Korisnik kori = new Korisnik((Long) 1L, "miksi", "sneletron123", "rola1", "Mihajla Pupina 69", "0616476379");
        
        //for(Karta kart : kartaDao.getKartList(kori)) {
        //    System.out.println("Karta: " + kart.getKartStatus());
        //}
                
        /*
        vraca listu aktuelnih koncerata
        */
        //for(Koncert konc : koncertDao.getList()) {
        //    System.out.println(konc.getKoncOpis());
        //}
    }
}
