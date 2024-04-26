/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

/**
 *
 * @author Zoran
 */
public class Osoba extends Model {
    private String ime, prezime,adresa;
    private int brojTelefona;
    
    private Osoba(int id, PodesavanjeBaze podesavanje) {
    super(id, podesavanje);
    }
    public static Osoba ucitaj(int id, String ime, String prezime, String adresa, int brojTelefona) {
    Osoba osoba = new Osoba(id, Podaci.getPodaci().getPodesavanjeOsoba());
    osoba.setIme(ime);
    osoba.setPrezime(prezime);
    osoba.setAdresa(adresa);
    osoba.setBrojTelefona(brojTelefona);
    return osoba;
    }
    public Osoba(String ime, String prezime, String adresa,int brojTelefona) {
    super(Podaci.getPodaci().getPodesavanjeOsoba());
    this.ime = ime;
    this.prezime = prezime;
    this.adresa = adresa;
    this.brojTelefona = brojTelefona;
    }
    public int getId() {
    return ID;
    }
    public String getIme() {
    return ime;
    }
    public void setIme(String ime) {
    this.ime = ime;
    }
    public String getPrezime() {
    return prezime;
    }
    public void setPrezime(String prezime) {
    this.prezime = prezime;
    }
    public String getAdresa() {
    return adresa;
    }
    public void setAdresa(String adresa) {
    this.adresa = adresa;
    }
    public int getBrojTelefona() {
    return brojTelefona;
    }
    public void setBrojTelefona(int brojTelefona) {
    this.brojTelefona = brojTelefona;
    }
    @Override
    public String toString() {
        return "Osoba{" + "ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + '}';
    }


}
