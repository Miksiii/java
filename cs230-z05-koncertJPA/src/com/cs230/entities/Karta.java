/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cs230.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "karta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Karta.findAll", query = "SELECT k FROM Karta k"),
    @NamedQuery(name = "Karta.findByKartId", query = "SELECT k FROM Karta k WHERE k.kartId = :kartId"),
    @NamedQuery(name = "Karta.findByKartMesto", query = "SELECT k FROM Karta k WHERE k.kartMesto = :kartMesto"),
    @NamedQuery(name = "Karta.findByKartStatus", query = "SELECT k FROM Karta k WHERE k.kartStatus = :kartStatus"),
    @NamedQuery(name = "Karta.findByKartNapomena", query = "SELECT k FROM Karta k WHERE k.kartNapomena = :kartNapomena"),
    @NamedQuery(name = "Karta.findByKartCena", query = "SELECT k FROM Karta k WHERE k.kartCena = :kartCena"),
    @NamedQuery(name = "Karta.getKartByKoriId", query= "SELECT kart FROM Karta kart WHERE kart.koriId = :koriId")
                    
        
})
public class Karta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KART_ID")
    private Long kartId;
    @Basic(optional = false)
    @Column(name = "KART_MESTO")
    private int kartMesto;
    @Basic(optional = false)
    @Column(name = "KART_STATUS")
    private String kartStatus;
    @Column(name = "KART_NAPOMENA")
    private String kartNapomena;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "KART_CENA")
    private BigDecimal kartCena;
    @JoinColumn(name = "KORI_ID", referencedColumnName = "KORI_ID")
    @ManyToOne
    private Korisnik koriId;
    @OneToMany(mappedBy = "kartId")
    private Collection<Koncert> koncertCollection;

    public Karta() {
    }

    public Karta(Long kartId) {
        this.kartId = kartId;
    }

    public Karta(Long kartId, int kartMesto, String kartStatus) {
        this.kartId = kartId;
        this.kartMesto = kartMesto;
        this.kartStatus = kartStatus;
    }

    public Long getKartId() {
        return kartId;
    }

    public void setKartId(Long kartId) {
        this.kartId = kartId;
    }

    public int getKartMesto() {
        return kartMesto;
    }

    public void setKartMesto(int kartMesto) {
        this.kartMesto = kartMesto;
    }

    public String getKartStatus() {
        return kartStatus;
    }

    public void setKartStatus(String kartStatus) {
        this.kartStatus = kartStatus;
    }

    public String getKartNapomena() {
        return kartNapomena;
    }

    public void setKartNapomena(String kartNapomena) {
        this.kartNapomena = kartNapomena;
    }

    public BigDecimal getKartCena() {
        return kartCena;
    }

    public void setKartCena(BigDecimal kartCena) {
        this.kartCena = kartCena;
    }

    public Korisnik getKoriId() {
        return koriId;
    }

    public void setKoriId(Korisnik koriId) {
        this.koriId = koriId;
    }

    @XmlTransient
    public Collection<Koncert> getKoncertCollection() {
        return koncertCollection;
    }

    public void setKoncertCollection(Collection<Koncert> koncertCollection) {
        this.koncertCollection = koncertCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kartId != null ? kartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Karta)) {
            return false;
        }
        Karta other = (Karta) object;
        if ((this.kartId == null && other.kartId != null) || (this.kartId != null && !this.kartId.equals(other.kartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.entities.Karta[ kartId=" + kartId + " ]";
    }
    
}
