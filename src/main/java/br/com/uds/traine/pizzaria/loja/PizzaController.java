package br.com.uds.traine.pizzaria.loja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> criar (@RequestBody PizzaDTO pizzaDTO){
        Pizza pizza = pizzaService.salvar(pizzaDTO);
        return new ResponseEntity<>(pizza, HttpStatus.CREATED);
    }

    @GetMapping("/findBy")
    public Pizza obter (@RequestParam("id")UUID id){
        return this.pizzaService.obter(id);
    }

    @PutMapping
    public ResponseEntity editar(@RequestParam("id")UUID id, @RequestBody PizzaDTO pizzaDTO){
        this.pizzaService.editar(id,pizzaDTO);
        return new ResponseEntity("Editado Com Sucesso", HttpStatus.OK);
    }

    @GetMapping
    public Set<Pizza> listar(){
        return  this.pizzaService.listar();
    }

    @DeleteMapping
    public  ResponseEntity remover(@RequestParam("id")UUID id){
        this.pizzaService.remover(id);
        return new ResponseEntity("Removido com sucesso!", HttpStatus.ACCEPTED);
    }
}