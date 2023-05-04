package UI;
import java.util.Collection;

import dao.vozoviDAO;
import model.Vozovi;
import util.UcitajTastatura;

public class VozoviUI {
	
	private static vozoviDAO vozoviDAO;
	
	public static void setVozoviDAO(vozoviDAO v) {
		VozoviUI.vozoviDAO = v;
	}
	
	public static void prikaziVozove() {
		 try {
			 Collection <Vozovi> vozovi = vozoviDAO.getVozovi();
			 for(Vozovi v: vozovi) {
				 System.out.println(v);
			 }
		 }
		 catch(Exception ex){
			 ex.printStackTrace();
			 System.out.println("Greska pri ucitavanju vozova");
			 
		 }
	}
	public static void prikaziVoz() {
		long id = UcitajTastatura.ucitajLong("Upisite id Voza: ");
		try {
			Vozovi voz = vozoviDAO.prikazVoza(id);
			System.out.println(voz);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Nema tog voza batiskec");
		}
	}
	
	
	

}
