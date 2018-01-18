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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OSOBY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoby.findAll", query = "SELECT o FROM Osoby o")
    , @NamedQuery(name = "Osoby.findByIdOsoby", query = "SELECT o FROM Osoby o WHERE o.idOsoby = :idOsoby")
    , @NamedQuery(name = "Osoby.findByImie", query = "SELECT o FROM Osoby o WHERE o.imie = :imie")
    , @NamedQuery(name = "Osoby.findByNazwisko", query = "SELECT o FROM Osoby o WHERE o.nazwisko = :nazwisko")
    , @NamedQuery(name = "Osoby.findByNrTel", query = "SELECT o FROM Osoby o WHERE o.nrTel = :nrTel")
    , @NamedQuery(name = "Osoby.findByAdres", query = "SELECT o FROM Osoby o WHERE o.adres = :adres")
    , @NamedQuery(name = "Osoby.findByMail", query = "SELECT o FROM Osoby o WHERE o.mail = :mail")
    , @NamedQuery(name = "Osoby.findByLogin", query = "SELECT o FROM Osoby o WHERE o.login = :login")
    , @NamedQuery(name = "Osoby.findByHas\u0142o", query = "SELECT o FROM Osoby o WHERE o.has\u0142o = :has\u0142o")})
public class Osoby implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OSOBY")
    private Integer idOsoby;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "IMIE")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NR_TEL")
    private int nrTel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADRES")
    private String adres;
    @Size(max = 45)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "HAS\u0141O")
    private String hasło;
    @JoinColumn(name = "ID_LOKALIZACJI", referencedColumnName = "ID_LOKALIZACJA")
    @ManyToOne(optional = false)
    private Lokalizacja idLokalizacji;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOsoby")
    private Collection<Sprzet> sprzetCollection;

    public Osoby() {
    }

    public Osoby(Integer idOsoby) {
        this.idOsoby = idOsoby;
    }

    public Osoby(Integer idOsoby, String imie, String nazwisko, int nrTel, String adres, String login, String hasło) {
        this.idOsoby = idOsoby;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTel;
        this.adres = adres;
        this.login = login;
        this.hasło = hasło;
    }

    public Integer getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(Integer idOsoby) {
        this.idOsoby = idOsoby;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNrTel() {
        return nrTel;
    }

    public void setNrTel(int nrTel) {
        this.nrTel = nrTel;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHasło() {
        return hasło;
    }

    public void setHasło(String hasło) {
        this.hasło = hasło;
    }

    public Lokalizacja getIdLokalizacji() {
        return idLokalizacji;
    }

    public void setIdLokalizacji(Lokalizacja idLokalizacji) {
        this.idLokalizacji = idLokalizacji;
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
        hash += (idOsoby != null ? idOsoby.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoby)) {
            return false;
        }
        Osoby other = (Osoby) object;
        if ((this.idOsoby == null && other.idOsoby != null) || (this.idOsoby != null && !this.idOsoby.equals(other.idOsoby))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Osoby[ idOsoby=" + idOsoby + " ]";
    }
    
}
