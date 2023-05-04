package daoImpl;

import java.sql.Connection;
import daoImpl.vozoviDaoImpl;
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
import util.UcitajTastatura;

public class KarteDAOImpl implements KarteDAO {
	
	private final Connection conn;
	private final vozoviDAO vozDAO;
	
	

	public KarteDAOImpl(Connection conn,vozoviDAO v) {
		this.conn = conn;
		this.vozDAO = v;
	}



	@Override
	public void prodajKartu(Karte k) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

	@Override
	public Karte ucitajKartu(long id) throws Exception {
		Karte karta = null;
		
		String sql = "Select voz,vremeKupovine,kupac,razred FROM karte WHERE idKarte = ?";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setLong(1, id);
			try(ResultSet rset = stmt.executeQuery()){
				if(rset.next()) {
					int kolona = 0;
					long idVoza = rset.getLong(++kolona);
					LocalDateTime vremeKupovine = rset.getTimestamp(++kolona).toLocalDateTime();
					String kupac = rset.getString(++kolona);
					int razred = rset.getInt(++kolona);
					Vozovi voz = vozDAO.prikazVoza(idVoza);
					karta = new Karte(id,voz,vremeKupovine,kupac,razred);
					
				}
			}
		}
		return karta;
		
	}



	@Override
	public Collection <Karte> ucitajKarte() throws Exception {
		Collection <Karte> karte = new ArrayList<Karte>();
		
		
		
		String sql = "Select idKarte, voz,vremeKupovine,kupac,razred FROM karte  ";
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			try(ResultSet rset = stmt.executeQuery()){
				while(rset.next()){
					int kolona = 0;
					long id = rset.getLong(++kolona);
					long idVoza = rset.getLong(++kolona);
					LocalDateTime vremeKupovine = rset.getTimestamp(++kolona).toLocalDateTime();
					String kupac = rset.getString(++kolona);
					int razred = rset.getInt(++kolona);
					Vozovi voz  =  vozDAO.prikazVoza(idVoza);
					
					Karte karta = new Karte(id,voz,vremeKupovine,kupac,razred);
					karte.add(karta);
					
				}
			}
		}
		return karte;
	}


    @Override
	public void prodajaKarte() throws Exception {
    	long id = UcitajTastatura.ucitajLong("Upisite id voza za koji Kupujuete kartu: ");
    	Vozovi voz = vozDAO.prikazVoza(id);
    	if(voz==null) {
    		System.out.println("Taj voz ne postoji!");
    		return;
    	}
    	if(voz.getBrojMesta() <=0) {
    		System.out.println("Nema vise mesta u vozu!");
    		return;
    	}
    	LocalDateTime vremeKupovine = LocalDateTime.now();
		if(vremeKupovine.compareTo(voz.getVremePolaska())>0){
			System.out.println("Voz je vec posao!");
			return;
			
		}
    	int razred = UcitajTastatura.ucitajInt("Upisite broj razreda: ");
    	if(razred !=1 && razred !=2) {
    		System.out.println("Nepostojeci razred!");
    		return;
    	}
    	
		int brojVoza = (int)id;
		
		String kupac = UcitajTastatura.ucitajString("Ime kupca: ");
		
		
		Karte k = new Karte(id,brojVoza,vremeKupovine,kupac,razred);
		
		
		
		String sql = "INSERT INTO karte (voz,vremeKupovine,kupac,razred) VALUES (?,?,?,?)";
		
		
			try (PreparedStatement stmt= conn.prepareStatement(sql)){
				int kolona = 0;
				stmt.setInt(++kolona, k.getBrojVoza());
				stmt.setTimestamp(++kolona, Timestamp.valueOf(k.getDatumProdaje()));
				stmt.setString(++kolona, k.getKupac());
				stmt.setInt(++kolona, k.getRazred());
				stmt.executeUpdate();
			
			
			
		}
		
		
	}



	
	

}
