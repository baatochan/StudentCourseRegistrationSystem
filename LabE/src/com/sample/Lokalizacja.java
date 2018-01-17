package com.sample;


public class Lokalizacja {

  private long idLokalizacja;
  private String miasto;
  private String kodPocztowy;


  public long getIdLokalizacja() {
    return idLokalizacja;
  }

  public void setIdLokalizacja(long idLokalizacja) {
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

}
