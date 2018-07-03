package br.com.uds.traine.pizzaria.loja;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public interface PizzaService {

    Pizza salvar(PizzaDTO pizzaDTO);
    Pizza editar(UUID id, PizzaDTO pizzaDTO);
    Pizza obter(UUID id);
    Set<Pizza> listar();
    void remover(UUID id);
}
