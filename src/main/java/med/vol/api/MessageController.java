package med.vol.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessageController {

    @GetMapping("/message")
    public Map<String, String> getMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hola, este es un mensaje JSON");
        return response;
    }
}
