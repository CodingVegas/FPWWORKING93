package com.promineotech.burrito.repositories;

import java.util.Optional;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;

public interface OrderRepository {
  Optional<Orders> get(String orderPK);

  /**
   * Deletes an Order
   * @param The unique orderPK
   * @return the deleted order if successful, otherwise and empty optional.
   */
  Optional<Orders> delete(String orderPK);
}
