package com.promineotech.burrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BurritoIngredients {
  private String order;
  private String ingredients;
  
  public BurritoIngredients(String order, String ingredients) {
    setOrder(order);
    setIngredients(ingredients);
  }
    
  public String getOrder() {
  return order;
  }
  public void setOrder(String order) {
    this.order = order;
  }
  public String getIngredients() {
    return ingredients;
  }
  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  
  @JsonIgnore
  public boolean isValid( ) {
    return (getOrder() != null) && (! getOrder().isEmpty()) &&
           (getIngredients() != null) && (! getIngredients().isEmpty()); 
  }


}