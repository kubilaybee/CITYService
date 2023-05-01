package qb.lie.cityservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qb.lie.cityservice.model.City;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cities")
public class CityController {

    @GetMapping
    public ResponseEntity<List<City>> getCities() {

        City city1 = new City("28","Giresun");
        City city2 = new City("34","Istanbul");
        City city3 = new City("06","Ankara");

        List<City> cities = Arrays.asList(city1,city2,city3);

        return new ResponseEntity<>(cities, OK);
    }
}
