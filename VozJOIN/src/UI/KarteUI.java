package UI;

import java.time.LocalDateTime;
import java.util.Collection;

import dao.KarteDAO;
import model.Karte;
import util.UcitajTastatura;

public class KarteUI {
	
	private static KarteDAO karteDAO;
	
	public static void setKarteDAO(KarteDAO k) {
		KarteUI.karteDAO = k;
	}
	
	public static void ucitajKartu() {
		long id = UcitajTastatura.ucitajLong("Upisite id karte");
		try {
			Karte k = karteDAO.ucitajKartu(id);
			System.out.println(k);
		} catch(Exception ex){
			ex.printStackTrace();
			System.out.println("Greska pri ucitavanju karte");
			
		}
	}
	public static void ucitajKarte() {
		try {
			Collection <Karte> karte = karteDAO.ucitajKarte();
			for(Karte k:karte) {
				System.out.println(k);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska pri ucitavanju karata");
		}
	}
	public static void prodajKartu() {
		
		
		
		try {
			
			karteDAO.prodajaKarte();
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Greska negde ima!!");
		}
	}

}
