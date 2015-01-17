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
@Table(name = "bend")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bend.findAll", query = "SELECT b FROM Bend b"),
    @NamedQuery(name = "Bend.findByBendId", query = "SELECT b FROM Bend b WHERE b.bendId = :bendId"),
    @NamedQuery(name = "Bend.findByBendNaziv", query = "SELECT b FROM Bend b WHERE b.bendNaziv = :bendNaziv"),
    @NamedQuery(name = "Bend.findByBendOpis", query = "SELECT b FROM Bend b WHERE b.bendOpis = :bendOpis"),
    @NamedQuery(name = "Bend.findByBendCena", query = "SELECT b FROM Bend b WHERE b.bendCena = :bendCena")})
public class Bend implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BEND_ID")
    private Long bendId;
    @Basic(optional = false)
    @Column(name = "BEND_NAZIV")
    private String bendNaziv;
    @Column(name = "BEND_OPIS")
    private String bendOpis;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BEND_CENA")
    private BigDecimal bendCena;
    @OneToMany(mappedBy = "bendId")
    private Collection<Koncert> koncertCollection;

    public Bend() {
    }

    public Bend(Long bendId) {
        this.bendId = bendId;
    }

    public Bend(Long bendId, String bendNaziv) {
        this.bendId = bendId;
        this.bendNaziv = bendNaziv;
    }

    public Long getBendId() {
        return bendId;
    }

    public void setBendId(Long bendId) {
        this.bendId = bendId;
    }

    public String getBendNaziv() {
        return bendNaziv;
    }

    public void setBendNaziv(String bendNaziv) {
        this.bendNaziv = bendNaziv;
    }

    public String getBendOpis() {
        return bendOpis;
    }

    public void setBendOpis(String bendOpis) {
        this.bendOpis = bendOpis;
    }

    public BigDecimal getBendCena() {
        return bendCena;
    }

    public void setBendCena(BigDecimal bendCena) {
        this.bendCena = bendCena;
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
        hash += (bendId != null ? bendId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bend)) {
            return false;
        }
        Bend other = (Bend) object;
        if ((this.bendId == null && other.bendId != null) || (this.bendId != null && !this.bendId.equals(other.bendId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cs230.entities.Bend[ bendId=" + bendId + " ]";
    }
    
}
