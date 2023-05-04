package model;

import java.time.LocalDateTime;

public class Karte {
	long idKarte;
	
	Vozovi voz;
	int brojVoza;
	LocalDateTime datumProdaje;
	String kupac;
	int razred;
	
	public long getIdKarte() {
		return idKarte;
	}
	public void setIdKarte(long idKarte) {
		this.idKarte = idKarte;
	}
	
	
	
	
	public Karte() {
		super();
		
	}
	@Override
	public String toString() {
		return "\n idKarte=" + idKarte + ", datumProdaje=" + datumProdaje + ", kupac=" + kupac + ", razred="
				+ razred + "]" +"\n";
	}
	public Karte(long idKarte, Vozovi voz, LocalDateTime datumProdaje, String kupac, int razred) {
		super();
		this.idKarte = idKarte;
		this.voz = voz;
		this.datumProdaje = datumProdaje;
		this.kupac = kupac;
		this.razred = razred;
	}
	public Karte(long idKarte, int brojVoza, LocalDateTime datumProdaje, String kupac, int razred) {
		super();
		this.idKarte = idKarte;
		this.brojVoza = brojVoza;
		this.datumProdaje = datumProdaje;
		this.kupac = kupac;
		this.razred = razred;
	}
	
	public Vozovi getVoz() {
		return voz;
	}
	public void setVoz(Vozovi voz) {
		this.voz = voz;
	}
	public LocalDateTime getDatumProdaje() {
		return datumProdaje;
	}
	public void setDatumProdaje(LocalDateTime datumProdaje) {
		this.datumProdaje = datumProdaje;
	}
	public String getKupac() {
		return kupac;
	}
	public void setKupac(String kupac) {
		this.kupac = kupac;
	}
	public int getRazred() {
		return razred;
	}
	public void setRazred(int razred) {
		this.razred = razred;
	}
	public int getBrojVoza() {
		return brojVoza;
	}
	public void setBrojVoza(int brojVoza) {
		this.brojVoza = brojVoza;
	}
	

}
