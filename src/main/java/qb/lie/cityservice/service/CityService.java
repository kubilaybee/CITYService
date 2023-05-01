package qb.lie.cityservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qb.lie.cityservice.exception.CityNotFoundException;
import qb.lie.cityservice.model.City;
import qb.lie.cityservice.repository.CityRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public List<City> getCities(String name) {
        if (name == null){
            return cityRepository.findAll();
        } else {
            return cityRepository.findByName(name);
        }
    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("City not Found with ID: "+id));
    }

    public void updateCity(String id, City newCity) {
        getCityById(id).setName(newCity.getName());
        cityRepository.save(getCityById(id));
    }
}
