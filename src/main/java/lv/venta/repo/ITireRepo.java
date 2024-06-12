package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Tire;

public interface ITireRepo extends CrudRepository<Tire, Integer>{

	ArrayList<Tire> findByPriceLessThan(float price);

	ArrayList<Tire> findByManufacturer(String manufacturer);
	
	Tire findById(int id);

}
