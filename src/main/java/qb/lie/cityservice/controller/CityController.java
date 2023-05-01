package qb.lie.cityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qb.lie.cityservice.model.City;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
public class CityController {

    private static final List<City> cities = new ArrayList<>();

    public CityController(){
        if (cities.isEmpty()){
            City city1 = new City(new Date(),"28","Giresun");
            City city2 = new City(new Date(),"34","Istanbul");
            City city3 = new City(new Date(),"06","Ankara");

            cities.add(city1);
            cities.add(city2);
            cities.add(city3);
        }
    }

    @GetMapping
    public ResponseEntity<List<City>> getCities() {

        return new ResponseEntity<>(cities, OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id){
        City result = getCityById(id);

        return new ResponseEntity<>(result,OK);
    }

    private City getCityById(String id) {
        return cities.stream()
                .filter(city -> city.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("City not Found"));
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCity){
        newCity.setCreateDate(new Date());
        cities.add(newCity);

        return new ResponseEntity<>(newCity,CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> getCity(@PathVariable String id,@RequestBody City city){
        getCityById(id).setName(city.getName());
        getCityById(id).setCreateDate(new Date());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id){
        cities.remove(getCityById(id));

        return new ResponseEntity<>(OK);
    }
}
