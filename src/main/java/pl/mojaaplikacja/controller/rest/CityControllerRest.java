package pl.mojaaplikacja.controller.rest;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.mojaaplikacja.model.City;
import pl.mojaaplikacja.repository.CityRepository;

@RestController
@RequestMapping("/api/cities")
public class CityControllerRest {

	private CityRepository cityRepository;

	@Autowired
	public CityControllerRest(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCities(@RequestParam(defaultValue="name") String orderBy){
		List<City> cities = cityRepository.findAll();
		if ("name".equals(orderBy)) {
			cities.sort(Comparator.comparing(City::getName));
		} else if ("population".equals(orderBy)) {
			cities.sort(Comparator.comparing(City::getPopulation));
		}
		
		return cities;
	}
	
	@GetMapping(path="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public City getCity(@PathVariable Long id) {
		City city = cityRepository.findOne(id);
		return city;
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addCity(@RequestBody City city) {
		cityRepository.save(city);
	}
}
