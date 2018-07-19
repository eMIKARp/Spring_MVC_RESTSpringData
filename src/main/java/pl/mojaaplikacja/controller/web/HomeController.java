package pl.mojaaplikacja.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.mojaaplikacja.model.City;

@Controller
public class HomeController {

	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("cityModel", new City());
		return "index"; 
	}
}
