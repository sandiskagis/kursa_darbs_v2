package lv.venta.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Tire;
import lv.venta.model.TireRating;
import lv.venta.model.TireSize;
import lv.venta.model.TireType;
import lv.venta.repo.ITireRepo;
import lv.venta.service.ITireFilterService;

@Service
public class TireFilterServiceImpl implements ITireFilterService{
	
	@Autowired
	private ITireRepo tireRepo;

	@Override
	public ArrayList<Tire> retrieveAll() throws Exception {
		if(tireRepo.count() == 0)
			throw new Exception("Tire list is empty");
		return (ArrayList<Tire>) tireRepo.findAll();
	}
	
	
	@Override
	public ArrayList<Tire> selectAllTiresPriceLessThan(float price) throws Exception{
		if(price < 0 || price > 1000) throw new Exception("The limit of price is wrong");
		
		return (ArrayList<Tire>) tireRepo.findByPriceLessThan(price);
	}
	
	@Override
	public ArrayList<Tire> selectAllTiresByManufacturer(String manufacturer) throws Exception{
		if(manufacturer == null) throw new Exception("The manufacturer can't be null");
		
		return (ArrayList<Tire>) tireRepo.findByManufacturer(manufacturer);
	}
	
	@Override
	public void updateById(int id, float price, String manufacturer, TireSize tireSize, TireType tireType, int loudnessDb, TireRating drivingInRain, TireRating fuelEfficiency)throws Exception{
		if(id < 0 || price < 0 || price > 1000 || manufacturer == null || tireSize == null || tireType == null || loudnessDb < 50 || loudnessDb > 90 || drivingInRain == null || fuelEfficiency == null)
			throw new Exception("Wrong input parameters");
		
		Tire updateTire = tireRepo.findById(id);
		updateTire.setPrice(price);
		updateTire.setManufacturer(manufacturer);
		updateTire.setTireSize(tireSize);
		updateTire.setTireType(tireType);
		updateTire.setLoudnessDb(loudnessDb);
		updateTire.setDrivingInRain(drivingInRain);
		updateTire.setFuelEfficiency(fuelEfficiency);
		
		tireRepo.save(updateTire);
	}
	
	@Override
	public Tire retrieveById(int id) throws Exception{
		if(id < 0)
			throw new Exception("Id should be positive");
		Tire result = tireRepo.findById(id);
		return result;
	}

}
