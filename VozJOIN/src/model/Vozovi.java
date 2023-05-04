package model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;

public class Vozovi {
	
	long id;
	int brojVoza;
	String naziv;
	LocalDateTime vremePolaska;
	float cenaKarte;
	int brojMesta;
	Collection <Karte> prodateKarte ;
	
	
	
	
	
	public void dodajKarte(Collection <Karte> k) {
		this.prodateKarte = k;
		
	}
	
	@Override
	public String toString() {
		if(this.prodateKarte==null) {
			return "Vozovi [id=" + id + ", brojVoza=" + brojVoza + ", naziv=" + naziv + ", vremePolaska=" + vremePolaska
					+ ", cenaKarte=" + cenaKarte + ", brojMesta=" + brojMesta + "]";
			
		}
		else {
			return "Vozovi [id=" + id + ", brojVoza=" + brojVoza + ", naziv=" + naziv + ", vremePolaska=" + vremePolaska
			+ ", cenaKarte=" + cenaKarte + ", brojMesta=" + brojMesta + "]"
			+"\nProdate karte: " + prodateKarte;
			} 
	}
	public Vozovi() {
		super();
	}
	public Vozovi(long id, int brojVoza, String naziv, LocalDateTime vremePolaska, float cenaKarte, int brojMesta) {
		super();
		this.id = id;
		this.brojVoza = brojVoza;
		this.naziv = naziv;
		this.vremePolaska = vremePolaska;
		this.cenaKarte = cenaKarte;
		this.brojMesta = brojMesta;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vozovi other = (Vozovi) obj;
		return id == other.id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getBrojVoza() {
		return brojVoza;
	}
	public void setBrojVoza(int brojVoza) {
		this.brojVoza = brojVoza;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public LocalDateTime getVremePolaska() {
		return vremePolaska;
	}
	public void setVremePolaska(LocalDateTime vremePolaska) {
		this.vremePolaska = vremePolaska;
	}
	public float getCenaKarte() {
		return cenaKarte;
	}
	public void setCenaKarte(float cenaKarte) {
		this.cenaKarte = cenaKarte;
	}
	public int getBrojMesta() {
		return brojMesta;
	}
	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

}
