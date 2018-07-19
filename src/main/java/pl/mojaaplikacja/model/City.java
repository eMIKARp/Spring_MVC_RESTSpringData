package pl.mojaaplikacja.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class City implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int population;
	
	
	
	public City() {
	}
	
	public City(Long id, String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPopulation(int population) {
		this.population = population;
	}

	
	
}
