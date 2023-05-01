package qb.lie.cityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import qb.lie.cityservice.model.City;

import java.util.List;

public interface CityRepository extends MongoRepository<City,String> {
    List<City> findByName(String name);

}
