package fr.amu.models;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

	List<Food>  findByType(String category);
}
