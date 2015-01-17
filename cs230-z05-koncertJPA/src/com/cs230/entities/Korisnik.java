/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findByKoriId", query = "SELECT k FROM Korisnik k WHERE k.koriId = :koriId"),
    @NamedQuery(name = "Korisnik.findByKoriUsername", query = "SELECT k FROM Korisnik k WHERE k.koriUsername = :koriUsername"),
    @NamedQuery(name = "Korisnik.findByKoriPassword", query = "SELECT k FROM Korisnik k WHERE k.koriPassword = :koriPassword"),
    @NamedQuery(name = "Korisnik.findByKoriRola", query = "SELECT k FROM Korisnik k WHERE k.koriRola = :koriRola"),
    @NamedQuery(name = "Korisnik.findByKoriAdresa", query = "SELECT k FROM Korisnik k WHERE k.koriAdresa = :koriAdresa"),
    @NamedQuery(name = "Korisnik.findByKoriTelefon", query = "SELECT k FROM Korisnik k WHERE k.koriTelefon = :koriTelefon"),
    //custom queries
    @NamedQuery(name = "Korisnik.findByUserAndPass", query="SELECT k FROM Korisnik k WHERE k.koriUsername = :koriUsername AND k.koriPassword = :koriPassword")
})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KORI_ID")
    private Long koriId;
    @Basic(optional = false)
    @Column(name = "KORI_USERNAME")
    private String koriUsername;
    @Basic(optional = false)
    @Column(name = "KORI_PASSWORD")
    private String koriPassword;
    @Basic(optional = false)
    @Column(name = "KORI_ROLA")
    private String koriRola;
    @Basic(optional = false)
    @Column(name = "KORI_ADRESA")
    private String koriAdresa;
    @Basic(optional = false)
    @Column(name = "KORI_TELEFON")
    private String koriTelefon;
    @OneToMany(mappedBy = "koriId")
    private Collection<Karta> kartaCollection;

    public Korisnik() {
    }

    public Korisnik(Long koriId) {
        this.koriId = koriId;
    }

    public Korisnik(Long koriId, String koriUsername, String koriPassword, String koriRola, String koriAdresa, String koriTelefon) {
        this.koriId = koriId;
        this.koriUsername = koriUsername;
        this.koriPassword = koriPassword;
        this.koriRola = koriRola;
        this.koriAdresa = koriAdresa;
        this.koriTelefon = koriTelefon;
    }

    public Long getKoriId() {
        return koriId;
    }

    public void setKoriId(Long koriId) {
        this.koriId = koriId;
    }

    public String getKoriUsername() {
        return koriUsername;
    }

    public void setKoriUsername(String koriUsername) {
        this.koriUsername = koriUsername;
    }

    public String getKoriPassword() {
        return koriPassword;
    }

    public void setKoriPassword(String koriPassword) {
        this.koriPassword = koriPassword;
    }

    public String getKoriRola() {
        return koriRola;
    }

    public void setKoriRola(String koriRola) {
        this.koriRola = koriRola;
    }

    public String getKoriAdresa() {
        return koriAdresa;
    }

    public void setKoriAdresa(String koriAdresa) {
        this.koriAdresa = koriAdresa;
    }

    public String getKoriTelefon() {
        return koriTelefon;
    }

    public void setKoriTelefon(String koriTelefon) {
        this.koriTelefon = koriTelefon;
    }

    @XmlTransient
    public Collection<Karta> getKartaCollection() {
        return kartaCollection;
    }

    public void setKartaCollection(Collection<Karta> kartaCollection) {
        this.kartaCollection = kartaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (koriId != null ? koriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.koriId == null && other.koriId != null) || (this.koriId != null && !this.koriId.equals(other.koriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.entities.Korisnik[ koriId=" + koriId + " ]";
    }
    
}
