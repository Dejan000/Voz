package dao;
import java.util.Collection;

import model.Vozovi;

public interface vozoviDAO {
	
	public Collection<Vozovi> getVozovi() throws Exception;
	public Vozovi prikazVoza(long id) throws Exception;
	

}
