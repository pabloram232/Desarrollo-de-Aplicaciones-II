package boots.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boots.model.Hotel;
import boots.service.HotelService;

@Controller
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@GetMapping("/all-hotels")
	public String allHotels(HttpServletRequest request){
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "hotel";
	}
	@GetMapping("/new-hotel")
	public String newHotel(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_H");
		return "hotel";
	}
	@PostMapping("/save-hotel")
	public String saveHotel(@ModelAttribute Hotel hotel, BindingResult bindingResult, HttpServletRequest request){
		hotelService.save(hotel);
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "hotel";
	}
	@GetMapping("/update-hotel")
	public String updateHotel(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("hotel", hotelService.findOne(id));
		request.setAttribute("mode", "MODE_UPDATE_H");
		return "hotel";
	}
	
	@GetMapping("/delete-hotel")
	public String deleteHotel(@RequestParam int id, HttpServletRequest request){
		hotelService.delete(id);
		request.setAttribute("hotels", hotelService.findAll());
		request.setAttribute("mode", "MODE_HOTELS");
		return "hotel";
	}
	

	
}
