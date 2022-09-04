package com.promineotech.burrito.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.promineotech.burrito.entity.BurritoIngredients;
import com.promineotech.burrito.entity.Customer;

@Repository
public class BurritoIngredientsJDBCRepository implements BurritoIngredientsRepository{
  private NamedParameterJdbcTemplate provider;
  
  public BurritoIngredientsJDBCRepository(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }
  
  @Override
  public Optional<BurritoIngredients> get(String order, String ingredients) {
    String sql = "SELECT order_pk, ingredients_pk "
        +"FROM burrito_ingredients "
        + "WHERE order_pk = :order_pk;";
    MapSqlParameterSource parameters = new MapSqlParameterSource();
    parameters.addValue("order_pk", order);
    
    List<BurritoIngredients> burritoIngredients = provider.query(sql, parameters, (rs, rowNum) -> {
      return new BurritoIngredients(rs.getString("order_pk"), rs.getString("ingredients_pk"));
    });
    if (burritoIngredients.isEmpty()) {
      return Optional.empty();
    }

  return Optional.of(burritoIngredients.get(0));
  }

}
