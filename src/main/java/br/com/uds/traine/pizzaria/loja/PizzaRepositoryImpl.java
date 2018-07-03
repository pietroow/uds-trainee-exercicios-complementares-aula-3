package br.com.uds.traine.pizzaria.loja;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component

public class PizzaRepositoryImpl implements PizzaRepository{

    private Set<Pizza> listPizzas = new HashSet();

    @Override
    public Pizza save(Pizza pizza) {
        listPizzas.add(pizza);
        return pizza;
    }

    @Override
    public Pizza findOne(UUID id) {
        for (Pizza pizza : listPizzas){
            if(pizza.getId().equals(id)){
                return pizza;
            }
        }
        return null;
    }

    @Override
    public Set<Pizza> findAll() {
        return listPizzas;
    }

    @Override
    public void delete(UUID id) {
        Pizza pizza = this.findOne(id);
        this.listPizzas.remove(pizza);
    }
}