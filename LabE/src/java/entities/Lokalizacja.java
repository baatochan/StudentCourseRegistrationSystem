/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pako-
 */
@Entity
@Table(name = "LOKALIZACJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lokalizacja.findAll", query = "SELECT l FROM Lokalizacja l")
    , @NamedQuery(name = "Lokalizacja.findByIdLokalizacja", query = "SELECT l FROM Lokalizacja l WHERE l.idLokalizacja = :idLokalizacja")
    , @NamedQuery(name = "Lokalizacja.findByMiasto", query = "SELECT l FROM Lokalizacja l WHERE l.miasto = :miasto")
    , @NamedQuery(name = "Lokalizacja.findByKodPocztowy", query = "SELECT l FROM Lokalizacja l WHERE l.kodPocztowy = :kodPocztowy")})
public class Lokalizacja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOKALIZACJA")
    private Integer idLokalizacja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MIASTO")
    private String miasto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "KOD_POCZTOWY")
    private String kodPocztowy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLokalizacji")
    private Collection<Osoby> osobyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLokalizacji")
    private Collection<Sprzet> sprzetCollection;

    public Lokalizacja() {
    }

    public Lokalizacja(Integer idLokalizacja) {
        this.idLokalizacja = idLokalizacja;
    }

    public Lokalizacja(Integer idLokalizacja, String miasto, String kodPocztowy) {
        this.idLokalizacja = idLokalizacja;
        this.miasto = miasto;
        this.kodPocztowy = kodPocztowy;
    }

    public Integer getIdLokalizacja() {
        return idLokalizacja;
    }

    public void setIdLokalizacja(Integer idLokalizacja) {
        this.idLokalizacja = idLokalizacja;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    @XmlTransient
    public Collection<Osoby> getOsobyCollection() {
        return osobyCollection;
    }

    public void setOsobyCollection(Collection<Osoby> osobyCollection) {
        this.osobyCollection = osobyCollection;
    }

    @XmlTransient
    public Collection<Sprzet> getSprzetCollection() {
        return sprzetCollection;
    }

    public void setSprzetCollection(Collection<Sprzet> sprzetCollection) {
        this.sprzetCollection = sprzetCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLokalizacja != null ? idLokalizacja.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lokalizacja)) {
            return false;
        }
        Lokalizacja other = (Lokalizacja) object;
        if ((this.idLokalizacja == null && other.idLokalizacja != null) || (this.idLokalizacja != null && !this.idLokalizacja.equals(other.idLokalizacja))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Lokalizacja[ idLokalizacja=" + idLokalizacja + " ]";
    }
    
}
