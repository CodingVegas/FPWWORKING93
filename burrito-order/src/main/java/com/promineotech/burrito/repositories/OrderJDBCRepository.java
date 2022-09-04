package com.promineotech.burrito.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.burrito.entity.Orders;
import com.promineotech.burrito.entity.OrdersInputModel;

@Repository
public class OrderJDBCRepository implements OrderRepository {
  private NamedParameterJdbcTemplate provider;
  private  Random random = new Random();
  
  public OrderJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;    
  }

  @Override
  public Optional<Orders> get(String orderPK) {
    String sql = "SELECT order_pk, customer_pk "
        + "From orders "
        + "WHERE order_pk = :order_pk;";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("order_pk", orderPK);
   
        List<Orders> orders = provider.query(sql, parameters,(rs, rowNum) -> {
          return new Orders(rs.getString("order_pk"), rs.getString("customer_pk"));
              
        });
        if (orders.isEmpty()) {
          return Optional.empty();
        }
        
        return Optional.of(orders.get(0));
  }

//  
  @Override
  public Optional<Orders> delete(String orderPK) {
    
    return Optional.empty();
  }

}
