package pl.mojaaplikacja.controller.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.mojaaplikacja.model.City;
import pl.mojaaplikacja.repository.CityRepository;

@Controller
@RequestMapping("/city")
public class CityControllerMvc {

	private CityRepository cityRepository;
	
	@Autowired
	public CityControllerMvc(CityRepository cityRepository) {
		this.cityRepository=cityRepository;
	}
	
	@GetMapping
	private String listCity(Model model) {
		List<City> cities = cityRepository.findAll();
		model.addAttribute("cityList", cities);
		return "list";
	}
	
	@PostMapping
	public String addCity(@ModelAttribute City cityModel, RedirectAttributes redirectAttributes) {
		cityRepository.save(cityModel);
		redirectAttributes.addFlashAttribute("message", "City added successfuly");
		return "redirect:/";
	}
}
