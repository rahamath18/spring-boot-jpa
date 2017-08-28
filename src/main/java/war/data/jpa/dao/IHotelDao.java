package war.data.jpa.dao;

import java.util.List;

import war.data.jpa.domain.Hotel;

public interface IHotelDao {

	List<Hotel> getAllHotel();
	
	Hotel getHotelById(long id);
	
	Hotel addHotel(Hotel hotel);
	
    void updateHotel(Hotel hotel);
    
    void deleteHotel(long id);
    
    boolean hotelExists(String code);

}
