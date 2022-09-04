package com.promineotech.burrito.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BurritoIngredientsInputModel {
  private String order;
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
  private String ingredients;
  
  @JsonIgnore
  public boolean isValid( ) {
    return (getOrder() != null) && (! getOrder().isEmpty()) &&
           (getIngredients() != null) && (! getIngredients().isEmpty()); 
  }


}
