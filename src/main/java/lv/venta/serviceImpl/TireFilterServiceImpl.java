package lv.venta.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Tire;
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
	
	

}
