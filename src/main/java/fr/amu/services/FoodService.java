package fr.amu.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Favorite;
import fr.amu.models.Food;
import fr.amu.models.FoodRepository;


@Service
public class FoodService {

	@Autowired//pour l'injection
	FoodRepository fr;//un food dao donner des resources de la base
	
	public void addFood(Food food) {
		fr.save(food);
	}
	/**
	 * pour avoir une liste de food depuis la base
	 * @return
	 */
	public List<Food> getAll(){
		return fr.findAll();
	}
	/**
	 * pour supprimer de la base un food
	 * @param id
	 */
	public void removeFood(Long foood) {
		fr.deleteById(foood);

	}
	
//	public List<Food> getByFavorite(Favorite isfavorite) {
//		// TODO Stub de la méthode généré automatiquement
//		return fr.findByFavorite(isfavorite);
//	}
	
	public Optional<Food> getFood(Long id) {
		return fr.findById(id);
	}
	
//	public void setFood(Food food) {
//		fr.update(food);
//	}
	
	public List<Food> findFoodByType(String type){
		return fr.findByType(type);
	}
}
