package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Lights;

public interface ILightsRepo extends CrudRepository<Lights, Integer>{

	ArrayList<Lights> findByPriceLessThan(float price);

	ArrayList<Lights> findByManufacturer(String manufacturer);
	
	Lights findById(int id);

}
