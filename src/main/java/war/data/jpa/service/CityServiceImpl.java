/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package war.data.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import war.data.jpa.dao.ICityDao;
import war.data.jpa.domain.City;

@Service
public class CityServiceImpl implements ICityService {
	
	@Autowired
	private ICityDao cityDao;
	
	@Override
	public City getCityById(int articleId) {
		City obj = cityDao.getCityById(articleId);
		return obj;
	}	
	@Override
	public List<City> getAllCity(){
		return cityDao.getAllCity();
	}
	@Override
	public  City addCity(City city){
		city = cityDao.addCity(city);
		return city;
    	        
	}
	@Override
	public void updateCity(City city) {
		cityDao.updateCity(city);
	}
	@Override
	public void deleteCity(long id) {
		cityDao.deleteCity(id);
	}
	
	@Override
	public City getCity(String string, String string2) {
		
		return null;
	}
	
}
