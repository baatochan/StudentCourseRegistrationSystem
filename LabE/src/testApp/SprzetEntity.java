package testApp;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SPRZET", schema = "ROOT")
public class SprzetEntity {
	private int idSprzet;
	private String typ;
	private String marka;
	private String parametry;
	private String stanSprzetu;
	private String model;

	@Id
	@Column(name = "ID_SPRZET")
	public int getIdSprzet() {
		return idSprzet;
	}

	public void setIdSprzet(int idSprzet) {
		this.idSprzet = idSprzet;
	}

	@Basic
	@Column(name = "TYP")
	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

	@Basic
	@Column(name = "MARKA")
	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	@Basic
	@Column(name = "PARAMETRY")
	public String getParametry() {
		return parametry;
	}

	public void setParametry(String parametry) {
		this.parametry = parametry;
	}

	@Basic
	@Column(name = "STAN_SPRZETU")
	public String getStanSprzetu() {
		return stanSprzetu;
	}

	public void setStanSprzetu(String stanSprzetu) {
		this.stanSprzetu = stanSprzetu;
	}

	@Basic
	@Column(name = "MODEL")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SprzetEntity that = (SprzetEntity) o;
		return idSprzet == that.idSprzet &&
				Objects.equals(typ, that.typ) &&
				Objects.equals(marka, that.marka) &&
				Objects.equals(parametry, that.parametry) &&
				Objects.equals(stanSprzetu, that.stanSprzetu) &&
				Objects.equals(model, that.model);
	}

	@Override
	public int hashCode() {

		return Objects.hash(idSprzet, typ, marka, parametry, stanSprzetu, model);
	}
}
