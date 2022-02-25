package es.supermercado.comida;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class comidaController {
    private Map<Long, Comida> comidas = new ConcurrentHashMap<>();
    private AtomicLong lastId = new AtomicLong();
    
    @PostMapping("/items/")
    @ResponseStatus(HttpStatus.CREATED)
    public Comida nuevoComida(@RequestBody Comida comida) {
        long id = lastId.incrementAndGet();
        comida.setId(id);
        comidas.put(id, comida);
        return comida;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Comida> getComida(@PathVariable long id) {
        Comida comida = comidas.get(id);
        if (comida != null) {
            return new ResponseEntity<>(comida, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
