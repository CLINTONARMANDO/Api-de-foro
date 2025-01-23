package med.vol.api.controllers;

import med.vol.api.modelentity.Respuesta;
import med.vol.api.repository.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @GetMapping
    public List<Respuesta> getAllRespuestas() {
        return respuestaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Respuesta getRespuestaById(@PathVariable Long id) {
        return respuestaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Respuesta createRespuesta(@RequestBody Respuesta respuesta) {
        return respuestaRepository.save(respuesta);
    }

    @PutMapping("/{id}")
    public Respuesta updateRespuesta(@PathVariable Long id, @RequestBody Respuesta respuesta) {
        if (respuestaRepository.existsById(id)) {
            respuesta.setId(id);
            return respuestaRepository.save(respuesta);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteRespuesta(@PathVariable Long id) {
        respuestaRepository.deleteById(id);
    }
}
