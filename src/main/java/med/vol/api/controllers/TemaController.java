package med.vol.api.controllers;

import med.vol.api.modelentity.Tema;
import med.vol.api.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temas")
public class TemaController {

    @Autowired
    private TemaRepository temaRepository;

    @GetMapping
    public List<Tema> getAllTemas() {
        return temaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Tema getTemaById(@PathVariable Long id) {
        return temaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Tema createTema(@RequestBody Tema tema) {
        return temaRepository.save(tema);
    }

    @PutMapping("/{id}")
    public Tema updateTema(@PathVariable Long id, @RequestBody Tema tema) {
        if (temaRepository.existsById(id)) {
            tema.setId(id);
            return temaRepository.save(tema);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTema(@PathVariable Long id) {
        temaRepository.deleteById(id);
    }
}
