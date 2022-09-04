package com.promineotech.burrito.controller;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.burrito.entity.BurritoIngredients;
import com.promineotech.burrito.service.BurritoIngredientsService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

  @RestController
  @OpenAPIDefinition(info = @Info(title = "Burrito Orders"))
  @Tag(name = "BurritoIngredients")
  @RequestMapping("/BurritoIngredients")
  public class BurritoIngredientsController {
    private BurritoIngredientsService service;
    
    public BurritoIngredientsController(BurritoIngredientsService service) {
      this.service = service;
    }
    
    @GetMapping(value ="{order}")
    public BurritoIngredients get(@PathVariable String order, String ingredients) {
      BurritoIngredients burritoIngredients = service.getBurritoIngredients(order, ingredients);
      if (burritoIngredients != null) {
        return burritoIngredients;
      }
      
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "The requested burrito ingredients was not found.");   
    }
  }
  