package qb.lie.cityservice.exception;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String msg){
        super(msg);
    }
}
