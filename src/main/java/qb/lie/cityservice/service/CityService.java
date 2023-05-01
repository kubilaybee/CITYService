package qb.lie.cityservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import qb.lie.cityservice.model.City;
import qb.lie.cityservice.repository.CityRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    public List<City> getCities() {
        return cityRepository.findAll();
    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not Found"));
    }
}
