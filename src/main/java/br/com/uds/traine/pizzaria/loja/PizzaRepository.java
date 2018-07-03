package br.com.uds.traine.pizzaria.loja;

import java.util.Set;
import java.util.UUID;

public interface PizzaRepository {

    Pizza save(Pizza pizza);
    Pizza findOne(UUID id);
    Set<Pizza> findAll();
    void delete(UUID id);

}