package war.data.jpa.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import war.data.jpa.domain.City;

@Transactional
@Repository
public class CityDao implements ICityDao {

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public City getCityById(long id) {
		return entityManager.find(City.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getAllCity() {
		String hql = "FROM City as ctry ORDER BY ctry.name";
		return (List<City>) entityManager.createQuery(hql).getResultList();
	}	
	
	@Override
	public City addCity(City city) {
		entityManager.persist(city);
		return city;
	}
	
	@Override
	public void updateCity(City city) {
		City ctry = getCityById(city.getId());
		ctry.setName(city.getName());
		ctry.setState(city.getState());
		ctry.setCountry(city.getCountry());
		ctry.setMap(city.getMap());
		entityManager.flush();
	}
	
	@Override
	public void deleteCity(long id) {
		entityManager.remove(getCityById(id));
	}
	
	@Override
	public boolean cityExists(String code) {
		String hql = "FROM City as ctry WHERE ctry.name = ? ";
		int count = entityManager.createQuery(hql)
						.setParameter(1, code)
						.getResultList().size();
		return count > 0 ? true : false;
	}

}
