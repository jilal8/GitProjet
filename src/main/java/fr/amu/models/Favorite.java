package fr.amu.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 * 
 * @author mahdi
 *
 */
@Entity
public class Favorite {

	@Id
	private String libelle;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Food> foods = new HashSet<Food>(0);
	
	public Favorite() {
		super();
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Set<Food> getFoods() {
		return foods;
	}
	public void setFood(Set<Food> foods) {
		this.foods = foods;
	}	
}
