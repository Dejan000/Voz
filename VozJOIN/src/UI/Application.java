package UI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.KarteDAO;

import dao.vozoviDAO;
import daoImpl.KarteDAOImpl;

import daoImpl.vozoviDaoImpl;

public class Application {
	
private static void initDatabase() throws SQLException {
		
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/vozTest?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
				"root", 
				"root"
				);
		vozoviDAO vozoviDAO = new vozoviDaoImpl(conn);
		VozoviUI.setVozoviDAO(vozoviDAO);
		KarteDAO karteDAO = new KarteDAOImpl(conn,vozoviDAO);
		KarteUI.setKarteDAO(karteDAO);
		//VozKartaDAO vozKartaDao = new VozKartaDAOImpl(conn,karteDAO);
		
}
	static {
		try {
			initDatabase();
		} catch (SQLException e) {
			System.out.println("Nema baze podataka batice!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		//VozoviUI.prikaziVozove();
		//VozoviUI.prikaziVoz(); 
		//KarteUI.ucitajKartu();
		KarteUI.prodajKartu();
		
		
		

	}

}
