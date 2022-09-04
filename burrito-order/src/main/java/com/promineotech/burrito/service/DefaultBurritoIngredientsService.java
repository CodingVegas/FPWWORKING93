package com.promineotech.burrito.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.burrito.entity.BurritoIngredients;
import com.promineotech.burrito.repositories.BurritoIngredientsRepository;

  @Service
  public class DefaultBurritoIngredientsService implements BurritoIngredientsService {
    private BurritoIngredientsRepository repository;
    
    public DefaultBurritoIngredientsService(BurritoIngredientsRepository repository) {
      this.repository = repository;  
    }
    
    @Override
    public BurritoIngredients getBurritoIngredients(String order, String ingredients) {
      if ((order == null) || (order.isEmpty())) {
        return null;
      }
      Optional<BurritoIngredients> burritoIngredients = repository.get(order, ingredients);
      if (burritoIngredients.isEmpty()) {
        return null;
      }
     return burritoIngredients.get();
    }
  }
