
package war.data.jpa.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import war.data.jpa.domain.City;

public interface ICityService {
	
	List<City> getAllCity();
	
	City getCityById(int id);
	
	public City getCity(String string, String string2);
	
	City addCity(City city);
	
    void updateCity(City city);
    
    void deleteCity(long id);

}
