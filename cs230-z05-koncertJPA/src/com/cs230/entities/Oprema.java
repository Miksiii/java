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
@Table(name = "oprema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oprema.findAll", query = "SELECT o FROM Oprema o"),
    @NamedQuery(name = "Oprema.findByOpreId", query = "SELECT o FROM Oprema o WHERE o.opreId = :opreId"),
    @NamedQuery(name = "Oprema.findByOpreNaziv", query = "SELECT o FROM Oprema o WHERE o.opreNaziv = :opreNaziv"),
    @NamedQuery(name = "Oprema.findByOpreOpis", query = "SELECT o FROM Oprema o WHERE o.opreOpis = :opreOpis"),
    @NamedQuery(name = "Oprema.findByOpreCena", query = "SELECT o FROM Oprema o WHERE o.opreCena = :opreCena")})
public class Oprema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "OPRE_ID")
    private Long opreId;
    @Basic(optional = false)
    @Column(name = "OPRE_NAZIV")
    private String opreNaziv;
    @Column(name = "OPRE_OPIS")
    private String opreOpis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "OPRE_CENA")
    private BigDecimal opreCena;
    @OneToMany(mappedBy = "opreId")
    private Collection<Koncert> koncertCollection;

    public Oprema() {
    }

    public Oprema(Long opreId) {
        this.opreId = opreId;
    }

    public Oprema(Long opreId, String opreNaziv) {
        this.opreId = opreId;
        this.opreNaziv = opreNaziv;
    }

    public Long getOpreId() {
        return opreId;
    }

    public void setOpreId(Long opreId) {
        this.opreId = opreId;
    }

    public String getOpreNaziv() {
        return opreNaziv;
    }

    public void setOpreNaziv(String opreNaziv) {
        this.opreNaziv = opreNaziv;
    }

    public String getOpreOpis() {
        return opreOpis;
    }

    public void setOpreOpis(String opreOpis) {
        this.opreOpis = opreOpis;
    }

    public BigDecimal getOpreCena() {
        return opreCena;
    }

    public void setOpreCena(BigDecimal opreCena) {
        this.opreCena = opreCena;
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
        hash += (opreId != null ? opreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oprema)) {
            return false;
        }
        Oprema other = (Oprema) object;
        if ((this.opreId == null && other.opreId != null) || (this.opreId != null && !this.opreId.equals(other.opreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.entities.Oprema[ opreId=" + opreId + " ]";
    }
    
}
