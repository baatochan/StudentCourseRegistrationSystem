package testApp;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OSOBY", schema = "ROOT")
public class OsobyEntity {
	private int idOsoby;
	private String imie;
	private String nazwisko;
	private int nrTel;
	private String adres;
	private String mail;
	private String login;
	private String hasło;

	@Id
	@Column(name = "ID_OSOBY")
	public int getIdOsoby() {
		return idOsoby;
	}

	public void setIdOsoby(int idOsoby) {
		this.idOsoby = idOsoby;
	}

	@Basic
	@Column(name = "IMIE")
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Basic
	@Column(name = "NAZWISKO")
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Basic
	@Column(name = "NR_TEL")
	public int getNrTel() {
		return nrTel;
	}

	public void setNrTel(int nrTel) {
		this.nrTel = nrTel;
	}

	@Basic
	@Column(name = "ADRES")
	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	@Basic
	@Column(name = "MAIL")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Basic
	@Column(name = "LOGIN")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Basic
	@Column(name = "HASŁO")
	public String getHasło() {
		return hasło;
	}

	public void setHasło(String hasło) {
		this.hasło = hasło;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OsobyEntity that = (OsobyEntity) o;
		return idOsoby == that.idOsoby &&
				nrTel == that.nrTel &&
				Objects.equals(imie, that.imie) &&
				Objects.equals(nazwisko, that.nazwisko) &&
				Objects.equals(adres, that.adres) &&
				Objects.equals(mail, that.mail) &&
				Objects.equals(login, that.login) &&
				Objects.equals(hasło, that.hasło);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idOsoby, imie, nazwisko, nrTel, adres, mail, login, hasło);
	}
}
