package boots.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boots.dao.HotelRepository;

import boots.model.Hotel;


@Service @Transactional
public class HotelService {
private final HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository){
		super();
		this.hotelRepository=hotelRepository;
	}
	
	public List<Hotel> findAll(){
		List<Hotel> hotels = new ArrayList<Hotel>();
		for(Hotel hotel : hotelRepository.findAll()){
			hotels.add(hotel);
		}
		return hotels;
	}
	
	public void save(Hotel hotel){
		hotelRepository.save(hotel);
	}
	
	public void delete(int id){
		hotelRepository.delete(id);
	}
	
	public Hotel findOne (int id){
		return hotelRepository.findOne(id);
	}


}
