package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Car;


public interface ICarRepo extends CrudRepository<Car,Integer>{

}