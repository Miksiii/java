/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Milan
 */
@Entity
@Table(name = "vozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vozilo.findAll", query = "SELECT v FROM Vozilo v"),
    @NamedQuery(name = "Vozilo.findByReference", query = "SELECT v FROM Vozilo v WHERE v.voziloId = :voziloRef"),
    @NamedQuery(name = "Vozilo.findByVoziloId", query = "SELECT v FROM Vozilo v WHERE v.voziloId = :voziloId"),
    @NamedQuery(name = "Vozilo.findByVoziloMarka", query = "SELECT v FROM Vozilo v WHERE v.voziloMarka = :voziloMarka"),
    @NamedQuery(name = "Vozilo.findByVoziloModel", query = "SELECT v FROM Vozilo v WHERE v.voziloModel = :voziloModel"),
    @NamedQuery(name = "Vozilo.findByVoziloGodiste", query = "SELECT v FROM Vozilo v WHERE v.voziloGodiste = :voziloGodiste"),
    @NamedQuery(name = "Vozilo.findByVoziloGorivo", query = "SELECT v FROM Vozilo v WHERE v.voziloGorivo = :voziloGorivo")})
public class Vozilo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOZILO_ID")
    private Integer voziloId;
    @Size(max = 120)
    @Column(name = "VOZILO_MARKA")
    private String voziloMarka;
    @Size(max = 120)
    @Column(name = "VOZILO_MODEL")
    private String voziloModel;
    @Column(name = "VOZILO_GODISTE")
    private Integer voziloGodiste;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VOZILO_GORIVO")
    private Float voziloGorivo;

    public Vozilo() {
    }

    public Vozilo(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public Integer getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public String getVoziloMarka() {
        return voziloMarka;
    }

    public void setVoziloMarka(String voziloMarka) {
        this.voziloMarka = voziloMarka;
    }

    public String getVoziloModel() {
        return voziloModel;
    }

    public void setVoziloModel(String voziloModel) {
        this.voziloModel = voziloModel;
    }

    public Integer getVoziloGodiste() {
        return voziloGodiste;
    }

    public void setVoziloGodiste(Integer voziloGodiste) {
        this.voziloGodiste = voziloGodiste;
    }

    public Float getVoziloGorivo() {
        return voziloGorivo;
    }

    public void setVoziloGorivo(Float voziloGorivo) {
        this.voziloGorivo = voziloGorivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voziloId != null ? voziloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vozilo)) {
            return false;
        }
        Vozilo other = (Vozilo) object;
        if ((this.voziloId == null && other.voziloId != null) || (this.voziloId != null && !this.voziloId.equals(other.voziloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.fit.entities.Vozilo[ voziloId=" + voziloId + " ]";
    }
    
}
