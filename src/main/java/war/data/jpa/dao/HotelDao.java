package war.data.jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import war.data.jpa.domain.Hotel;

@Transactional
@Repository
public class HotelDao implements IHotelDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Hotel getHotelById(long id) {
		return entityManager.find(Hotel.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> getAllHotel() {
		String hql = "FROM Hotel as htl ORDER BY htl.name";
		return (List<Hotel>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public Hotel addHotel(Hotel hotel) {
		entityManager.persist(hotel);
		return hotel;
	}
	
	@Override
	public void updateHotel(Hotel hotel) {
//		Hotel ctry = getHotelById(hotel.getId());
//		ctry.setName(hotel.getName());
//		ctry.setState(hotel.getState());
//		ctry.setCountry(hotel.getCountry());
//		ctry.setMap(hotel.getMap());
//		entityManager.flush();
	}
	
	@Override
	public void deleteHotel(long id) {
		entityManager.remove(getHotelById(id));
	}
	
	@Override
	public boolean hotelExists(String code) {
		String hql = "FROM Hotel as htl WHERE htl.name = ? ";
		int count = entityManager.createQuery(hql)
						.setParameter(1, code)
						.getResultList().size();
		return count > 0 ? true : false;
	}

}
