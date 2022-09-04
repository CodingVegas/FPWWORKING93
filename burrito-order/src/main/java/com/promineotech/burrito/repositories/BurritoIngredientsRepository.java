package com.promineotech.burrito.repositories;

import java.util.Optional;
import com.promineotech.burrito.entity.BurritoIngredients;


public interface BurritoIngredientsRepository {

  Optional<BurritoIngredients> get (String order, String ingredients);
}
