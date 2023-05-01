package qb.lie.cityservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qb.lie.cityservice.model.City;
import qb.lie.cityservice.service.CityService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<City>> getCities() {

        return new ResponseEntity<>(cityService.getCities(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCity(@PathVariable String id){

        return new ResponseEntity<>(getCityById(id),OK);
    }

    private City getCityById(String id) {
        return cityService.getCityById(id);
    }

    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City newCity){

        return new ResponseEntity<>(cityService.createCity(newCity),CREATED);

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Void> getCity(@PathVariable String id,@RequestBody City city){
        getCityById(id).setName(city.getName());
        getCityById(id).setCreateDate(new Date());

        return new ResponseEntity<>(OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable String id){
        cityService.deleteCity(id);

        return new ResponseEntity<>(OK);
    }
}
