package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import dao.KarteDAO;
import dao.vozoviDAO;
import model.Karte;
import model.Vozovi;

public class vozoviDaoImpl implements vozoviDAO {
	
	private final Connection conn;
	
	
	

	public  vozoviDaoImpl(Connection conn) {
		this.conn = conn;
		
	}

	@Override
	public Collection<Vozovi> getVozovi() throws Exception {
		Collection <Vozovi> vozovi = new ArrayList<Vozovi>(); 
		
		String sql = 
				"SELECT id,brojVoza,naziv,vremePolaska,cenaKarte,brojMesta FROM vozovi";
				
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()) {
					int kolona = 0;
					long id  = rset.getLong(++kolona);
					int brojVoza = rset.getInt(++kolona);
					String naziv = rset.getString(++kolona);
					LocalDateTime vremePolaska = rset.getTimestamp(++kolona).toLocalDateTime();
				
					float cenaKarte  = rset.getFloat(++kolona);
					int brojMesta = rset.getInt(++kolona);
					Vozovi voz = new Vozovi(id,brojVoza,naziv,vremePolaska,cenaKarte,brojMesta);
					vozovi.add(voz);
				}
				
				
			}
		}
		return vozovi;
	}

	@Override
	public  Vozovi prikazVoza(long id) throws Exception {
		Collection <Karte> karte = new ArrayList<Karte>();
		//karte = karteDAO.ucitajKarte();
		Vozovi voz = null;
		String sql = 
				//"SELECT brojVoza, naziv, vremePolaska,cenaKarte,brojMesta FROM vozovi WHERE id  = ?";
				"select v.brojVoza,v.naziv,v.VremePolaska,v.cenaKarte,v.brojMesta\r\n"
				+ ",k.idKarte,k.vremeKupovine,k.kupac,k.razred\r\n"
				+ "from vozovi v\r\n"
				+ "join karte k on k.voz = v.id\r\n"
				+ "WHERE v.id = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setLong(1, id);
			try(ResultSet rset = stmt.executeQuery()){
				if(rset.next()) {
				int kolona = 0;
				int brojVoza = rset.getInt(++kolona);
				String naziv = rset.getString(++kolona);
				LocalDateTime vremePolaska = rset.getTimestamp(++kolona).toLocalDateTime();
				float cenaKarte  = rset.getFloat(++kolona);
				int brojMesta = rset.getInt(++kolona);
				voz = new Vozovi(id,brojVoza,naziv,vremePolaska,cenaKarte,brojMesta);
				while(rset.next()) {
					voz.setBrojMesta(voz.getBrojMesta() - 1);
					int idKarte = rset.getInt(6);
					LocalDateTime vremeKupovine = rset.getTimestamp(7).toLocalDateTime();
					String kupac = rset.getString(8);
					int razred = rset.getInt(9);
					Karte karta = new Karte(idKarte,null,vremeKupovine,kupac,razred);
					karte.add(karta);
					
					
				}
				
				voz.dodajKarte(karte);
				
				}
				
				
			}
		}
		return voz;
	}
	
	

}
