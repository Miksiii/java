/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "koncert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Koncert.findAll", query = "SELECT k FROM Koncert k"),
    @NamedQuery(name = "Koncert.findByKoncId", query = "SELECT k FROM Koncert k WHERE k.koncId = :koncId"),
    @NamedQuery(name = "Koncert.findByKoncNaziv", query = "SELECT k FROM Koncert k WHERE k.koncNaziv = :koncNaziv"),
    @NamedQuery(name = "Koncert.findByKoncAdresa", query = "SELECT k FROM Koncert k WHERE k.koncAdresa = :koncAdresa"),
    @NamedQuery(name = "Koncert.findByKoncKontakt", query = "SELECT k FROM Koncert k WHERE k.koncKontakt = :koncKontakt"),
    @NamedQuery(name = "Koncert.findByKoncBrojMesta", query = "SELECT k FROM Koncert k WHERE k.koncBrojMesta = :koncBrojMesta"),
    @NamedQuery(name = "Koncert.findByKoncOpis", query = "SELECT k FROM Koncert k WHERE k.koncOpis = :koncOpis"),
    @NamedQuery(name = "Koncert.findByKoncDatum", query = "SELECT k FROM Koncert k WHERE k.koncDatum = :koncDatum")})
    @NamedQuery(name = "Koncert.findActual", query = "SELECT k FROM Koncert k WHERE k.koncDatum >= CURRENT_TIMESTAMP")
public class Koncert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KONC_ID")
    private Long koncId;
    @Basic(optional = false)
    @Column(name = "KONC_NAZIV")
    private String koncNaziv;
    @Column(name = "KONC_ADRESA")
    private String koncAdresa;
    @Column(name = "KONC_KONTAKT")
    private String koncKontakt;
    @Basic(optional = false)
    @Column(name = "KONC_BROJ_MESTA")
    private int koncBrojMesta;
    @Column(name = "KONC_OPIS")
    private String koncOpis;
    @Column(name = "KONC_DATUM")
    @Temporal(TemporalType.DATE)
    private Date koncDatum;
    @JoinColumn(name = "OPRE_ID", referencedColumnName = "OPRE_ID")
    @ManyToOne
    private Oprema opreId;
    @JoinColumn(name = "BEND_ID", referencedColumnName = "BEND_ID")
    @ManyToOne
    private Bend bendId;
    @JoinColumn(name = "KART_ID", referencedColumnName = "KART_ID")
    @ManyToOne
    private Karta kartId;

    public Koncert() {
    }

    public Koncert(Long koncId) {
        this.koncId = koncId;
    }

    public Koncert(Long koncId, String koncNaziv, int koncBrojMesta) {
        this.koncId = koncId;
        this.koncNaziv = koncNaziv;
        this.koncBrojMesta = koncBrojMesta;
    }

    public Long getKoncId() {
        return koncId;
    }

    public void setKoncId(Long koncId) {
        this.koncId = koncId;
    }

    public String getKoncNaziv() {
        return koncNaziv;
    }

    public void setKoncNaziv(String koncNaziv) {
        this.koncNaziv = koncNaziv;
    }

    public String getKoncAdresa() {
        return koncAdresa;
    }

    public void setKoncAdresa(String koncAdresa) {
        this.koncAdresa = koncAdresa;
    }

    public String getKoncKontakt() {
        return koncKontakt;
    }

    public void setKoncKontakt(String koncKontakt) {
        this.koncKontakt = koncKontakt;
    }

    public int getKoncBrojMesta() {
        return koncBrojMesta;
    }

    public void setKoncBrojMesta(int koncBrojMesta) {
        this.koncBrojMesta = koncBrojMesta;
    }

    public String getKoncOpis() {
        return koncOpis;
    }

    public void setKoncOpis(String koncOpis) {
        this.koncOpis = koncOpis;
    }

    public Date getKoncDatum() {
        return koncDatum;
    }

    public void setKoncDatum(Date koncDatum) {
        this.koncDatum = koncDatum;
    }

    public Oprema getOpreId() {
        return opreId;
    }

    public void setOpreId(Oprema opreId) {
        this.opreId = opreId;
    }

    public Bend getBendId() {
        return bendId;
    }

    public void setBendId(Bend bendId) {
        this.bendId = bendId;
    }

    public Karta getKartId() {
        return kartId;
    }

    public void setKartId(Karta kartId) {
        this.kartId = kartId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (koncId != null ? koncId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Koncert)) {
            return false;
        }
        Koncert other = (Koncert) object;
        if ((this.koncId == null && other.koncId != null) || (this.koncId != null && !this.koncId.equals(other.koncId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.entities.Koncert[ koncId=" + koncId + " ]";
    }
    
}
