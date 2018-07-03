package br.com.uds.traine.pizzaria.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class PizzaServiceImpl implements PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public Pizza salvar(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza(pizzaDTO.getMassa() , pizzaDTO.getQueijo() , pizzaDTO.getMolho() , pizzaDTO.getSabor() , pizzaDTO.getTempoDePreparo());
        return this.pizzaRepository.save(pizza);
    }

    @Override
    public Pizza editar(UUID id, PizzaDTO pizzaDTO) {
        Pizza pizzaRecuperada = this.obter(id);
        remover(id);
        pizzaRecuperada.setMassa(pizzaDTO.getMassa());
        pizzaRecuperada.setQueijo(pizzaDTO.getQueijo());
        pizzaRecuperada.setMolho(pizzaDTO.getMolho());
        pizzaRecuperada.setSabor(pizzaDTO.getSabor());
        pizzaRecuperada.setTempoDePreparo(pizzaDTO.getTempoDePreparo());
        return this.pizzaRepository.save(pizzaRecuperada);
    }

    @Override
    public Pizza obter(UUID id) {
        return this.pizzaRepository.findOne(id);
    }

    @Override
    public Set<Pizza> listar() {
        return this.pizzaRepository.findAll();
    }

    @Override
    public void remover(UUID id) {
        this.pizzaRepository.delete(id);
    }


}
