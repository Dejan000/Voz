package dao;

import java.util.Collection;

import model.Karte;

public interface KarteDAO {
	
	public void prodajKartu(Karte k) throws Exception;
	public Karte ucitajKartu(long id) throws Exception;
	public Collection<Karte> ucitajKarte() throws Exception;
	public void prodajaKarte() throws Exception;

}
