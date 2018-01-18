/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pako-
 */
@Entity
@Table(name = "SPRZET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sprzet.findAll", query = "SELECT s FROM Sprzet s")
    , @NamedQuery(name = "Sprzet.findByIdSprzet", query = "SELECT s FROM Sprzet s WHERE s.idSprzet = :idSprzet")
    , @NamedQuery(name = "Sprzet.findByTyp", query = "SELECT s FROM Sprzet s WHERE s.typ = :typ")
    , @NamedQuery(name = "Sprzet.findByMarka", query = "SELECT s FROM Sprzet s WHERE s.marka = :marka")
    , @NamedQuery(name = "Sprzet.findByParametry", query = "SELECT s FROM Sprzet s WHERE s.parametry = :parametry")
    , @NamedQuery(name = "Sprzet.findByStanSprzetu", query = "SELECT s FROM Sprzet s WHERE s.stanSprzetu = :stanSprzetu")
    , @NamedQuery(name = "Sprzet.findByModel", query = "SELECT s FROM Sprzet s WHERE s.model = :model")})
public class Sprzet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SPRZET")
    private Integer idSprzet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "TYP")
    private String typ;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MARKA")
    private String marka;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "PARAMETRY")
    private String parametry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "STAN_SPRZETU")
    private String stanSprzetu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "MODEL")
    private String model;
    @JoinColumn(name = "ID_LOKALIZACJI", referencedColumnName = "ID_LOKALIZACJA")
    @ManyToOne(optional = false)
    private Lokalizacja idLokalizacji;
    @JoinColumn(name = "ID_OSOBY", referencedColumnName = "ID_OSOBY")
    @ManyToOne(optional = false)
    private Osoby idOsoby;

    public Sprzet() {
    }

    public Sprzet(Integer idSprzet) {
        this.idSprzet = idSprzet;
    }

    public Sprzet(Integer idSprzet, String typ, String marka, String parametry, String stanSprzetu, String model) {
        this.idSprzet = idSprzet;
        this.typ = typ;
        this.marka = marka;
        this.parametry = parametry;
        this.stanSprzetu = stanSprzetu;
        this.model = model;
    }

    public Integer getIdSprzet() {
        return idSprzet;
    }

    public void setIdSprzet(Integer idSprzet) {
        this.idSprzet = idSprzet;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getParametry() {
        return parametry;
    }

    public void setParametry(String parametry) {
        this.parametry = parametry;
    }

    public String getStanSprzetu() {
        return stanSprzetu;
    }

    public void setStanSprzetu(String stanSprzetu) {
        this.stanSprzetu = stanSprzetu;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Lokalizacja getIdLokalizacji() {
        return idLokalizacji;
    }

    public void setIdLokalizacji(Lokalizacja idLokalizacji) {
        this.idLokalizacji = idLokalizacji;
    }

    public Osoby getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(Osoby idOsoby) {
        this.idOsoby = idOsoby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSprzet != null ? idSprzet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sprzet)) {
            return false;
        }
        Sprzet other = (Sprzet) object;
        if ((this.idSprzet == null && other.idSprzet != null) || (this.idSprzet != null && !this.idSprzet.equals(other.idSprzet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Sprzet[ idSprzet=" + idSprzet + " ]";
    }
    
}
