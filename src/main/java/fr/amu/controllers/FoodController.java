package fr.amu.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;


import fr.amu.models.Favorite;
//import fr.amu.models.FavoriteRepository;
import fr.amu.models.Food;

import fr.amu.services.FoodService;


@Controller
public class FoodController {

	private static final Logger log = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	ServletContext context;
	
	@Autowired 
	FoodService fs;
	
	@Autowired 
//	FavoriteRepository fr;
	
	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //
	
	// TODO : completer avec les methodes adequates
	
	/**
	 * to add a new food
	 * @param model
	 * @param nom
	 * @param brand
	 * @param type
	 * @param quality
	 * @return the home page
	 */
	@RequestMapping(value = "/food/add", method = RequestMethod.POST)
	public String add(ModelMap model, @RequestParam("nom") String nom, @RequestParam("brand") String brand,
			@RequestParam("type") String type, @RequestParam("quality") String quality) {
		
		Food food = new Food();
		food.setName(nom);
		food.setBrand(brand);
		food.setType(type);
		food.setQuality(quality);
		System.out.println(food);
		 fs.addFood(food);
		
		final List<Food> listefood = fs.getAll();
		model.put("listFood", listefood);
		return "index";
	}
	/**
	 * pour supprimer une food
	 * @param model
	 * @param id
	 * @return la page d'accueil avec une liste actualisé
	 */
	@RequestMapping(value = "/food/remove", method = RequestMethod.POST)
	public String remove(ModelMap model, @RequestParam("foodID") Long id) {
		fs.removeFood(id);;
		//apres avoir supprimer l'element en question, on reactualise la liste de food
		final List<Food> listefood = fs.getAll();
		model.put("listFood", listefood);
		return "index";
	}

	
	
	@RequestMapping(value = "/food/type", method = RequestMethod.GET)
	public String research(ModelMap model, @RequestParam("type") String type) {
		final List<Food> listefoos;
		//si la type est vide on afficher getallproduct
		if(type.equals("ALL")) {
			listefoos = fs.getAll();
		}else {//si non affiche on filtre selon le type
			listefoos = fs.findFoodByType(type);
		}
		//on passe la liste a la vue
		model.put("listFood", listefoos);
		return "index";

	}
	
	
}
