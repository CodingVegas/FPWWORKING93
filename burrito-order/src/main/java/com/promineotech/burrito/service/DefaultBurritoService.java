package com.promineotech.burrito.service;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.promineotech.burrito.entity.Ingredients;
import com.promineotech.burrito.entity.IngredientsInputModel;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;
import com.promineotech.burrito.repositories.OrderRepository;

@Service
public class DefaultBurritoService implements BurritoService{
  private OrderRepository repository;
  
  public DefaultBurritoService(OrderRepository repository) {
    this.repository = repository;  
  }
  
  @Override
  public Orders getOrder(String orderPK) {
    if ((orderPK == null) || (orderPK.isEmpty())) {
      return null;
    }
    
    Optional<Orders> orders = repository.get(orderPK);
    if (orders.isEmpty()) {
      return null;
    }
    return orders.get();
  }

  @Override
  public Orders deleteOrder(String orderPK) {
    if ((orderPK == null) || (orderPK.isEmpty()) ) {
      return null;
    }
    Optional<Orders> deleted = repository.delete(orderPK);
    if (deleted.isPresent()) {
      return deleted.get();
    }
    return null;
  }
}

