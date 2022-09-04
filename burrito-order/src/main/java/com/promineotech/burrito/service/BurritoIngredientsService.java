package com.promineotech.burrito.service;

import com.promineotech.burrito.entity.BurritoIngredients;


public interface BurritoIngredientsService {
  BurritoIngredients getBurritoIngredients(String order_pk, String ingredients_pk);

}
