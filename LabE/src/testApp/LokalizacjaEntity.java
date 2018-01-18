package testApp;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LOKALIZACJA", schema = "ROOT")
public class LokalizacjaEntity {
	private int idLokalizacja;
	private String miasto;
	private String kodPocztowy;

	@Id
	@Column(name = "ID_LOKALIZACJA")
	public int getIdLokalizacja() {
		return idLokalizacja;
	}

	public void setIdLokalizacja(int idLokalizacja) {
		this.idLokalizacja = idLokalizacja;
	}

	@Basic
	@Column(name = "MIASTO")
	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	@Basic
	@Column(name = "KOD_POCZTOWY")
	public String getKodPocztowy() {
		return kodPocztowy;
	}

	public void setKodPocztowy(String kodPocztowy) {
		this.kodPocztowy = kodPocztowy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LokalizacjaEntity that = (LokalizacjaEntity) o;
		return idLokalizacja == that.idLokalizacja &&
				Objects.equals(miasto, that.miasto) &&
				Objects.equals(kodPocztowy, that.kodPocztowy);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idLokalizacja, miasto, kodPocztowy);
	}
}
