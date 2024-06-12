package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Tire;
import lv.venta.model.TireRating;
import lv.venta.model.TireSize;
import lv.venta.model.TireType;

public interface ITireFilterService {

	public abstract ArrayList<Tire> retrieveAll() throws Exception;

	ArrayList<Tire> selectAllTiresPriceLessThan(float price) throws Exception;

	ArrayList<Tire> selectAllTiresByManufacturer(String manufacturer) throws Exception;

	public abstract void updateById(int id, float price, String manufacturer, TireSize size, TireType type, int loudness,
			TireRating drivingInRain, TireRating fuelEfficiency) throws Exception;

	Tire retrieveById(int id) throws Exception;
	
}
