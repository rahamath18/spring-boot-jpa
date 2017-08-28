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

import war.data.jpa.dao.IHotelDao;
import war.data.jpa.domain.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;
	
	@Override
	public Hotel getHotelById(int articleId) {
		Hotel obj = hotelDao.getHotelById(articleId);
		return obj;
	}	
	@Override
	public List<Hotel> getAllHotel(){
		return hotelDao.getAllHotel();
	}
	@Override
	public  Hotel addHotel(Hotel hotel){
		hotel = hotelDao.addHotel(hotel);
		return hotel;
    	        
	}
	@Override
	public void updateHotel(Hotel hotel) {
		hotelDao.updateHotel(hotel);
	}
	@Override
	public void deleteHotel(long id) {
		hotelDao.deleteHotel(id);
	}

}
