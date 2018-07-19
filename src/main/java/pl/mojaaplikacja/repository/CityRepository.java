package pl.mojaaplikacja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.mojaaplikacja.model.City;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {

}
