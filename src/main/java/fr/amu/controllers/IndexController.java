package fr.amu.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.amu.models.Food;
import fr.amu.services.FoodService;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ServletContext context;
	
	@Autowired
	FoodService fs;

	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le
													// graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //

	// TODO : completer avec les methodes adequates
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Food> listefood = fs.getAll();

		pModel.put("listFood", listefood);

		return "index";
	}

	@RequestMapping(value = "/shutdown", method = RequestMethod.GET)
	public void shutdown() {
		System.exit(0);
	}

}