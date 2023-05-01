package qb.lie.cityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import qb.lie.cityservice.model.City;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends MongoRepository<City,String> {
    List<City> findAllByName(String name);
    Optional<City> findByName(String name);

}
