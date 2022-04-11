package fr.amu.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Food {
	public enum QUALITY {EXCELLENT, GOOD, MEDIOCRE, BAD};
	public enum TYPE {DRINK, MEAT, VEGETABLE};
	/**
	 * les propriétes de la  class food
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String brand;
	private String quality;
	private String type;
	
	/**
	 * les constructeurs
	 */
	public Food() {
		
	}
	
	
	public Food(Long id, String nom, String brand, String type) {
		super();
		this.id = id;
		this.name = nom;
		this.brand = brand;
		this.type = type;
		
	}

	/**
	 * 
	 * les accesseurs et getteurs
	 */

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}
	//la methode toString(), pour une description de la classe food
	@Override
	public String toString() {
		return "Food [id=" + id + ", nom=" + name + ", brand=" + brand + ", type=" + type
				+ "]";
	}
	
	
	
	
}
