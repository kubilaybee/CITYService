package qb.lie.cityservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import qb.lie.cityservice.model.City;

public interface CityRepository extends MongoRepository<City,String> {
}
