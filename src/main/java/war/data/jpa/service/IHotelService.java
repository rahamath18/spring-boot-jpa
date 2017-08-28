
package war.data.jpa.service;

import java.util.List;

import org.springframework.data.repository.Repository;

import war.data.jpa.domain.Hotel;

interface IHotelService {

	List<Hotel> getAllHotel();
	
	Hotel getHotelById(int id);
	
	Hotel addHotel(Hotel hotel);
	
    void updateHotel(Hotel hotel);
    
    void deleteHotel(long id);

}
