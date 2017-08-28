package war.data.jpa.dao;

import java.util.List;

import war.data.jpa.domain.City;

public interface ICityDao {

	List<City> getAllCity();
	
	City getCityById(long id);
	
	City addCity(City city);
	
    void updateCity(City city);
    
    void deleteCity(long id);
    
    boolean cityExists(String code);
    
    //public City getCity(String string, String string2);
}
