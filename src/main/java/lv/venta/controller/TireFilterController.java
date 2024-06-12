package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.ITireFilterService;

@Controller
@RequestMapping("/tire/filter")
public class TireFilterController {

	@Autowired
	private ITireFilterService tireService;
	
	@GetMapping("/all")//localhost:8080/tire/filter/all
	public String getTireAll(Model model) {
		try {
			model.addAttribute("mydata", tireService.retrieveAll());
			model.addAttribute("msg", "All tires");
			return "tire-all-show-page";
		}
		catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
	
}
