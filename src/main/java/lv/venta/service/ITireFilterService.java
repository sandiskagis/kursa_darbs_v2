package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Tire;

public interface ITireFilterService {

	public abstract ArrayList<Tire> retrieveAll() throws Exception;
	
}
