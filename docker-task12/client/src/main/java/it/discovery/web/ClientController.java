package it.discovery.web;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {
    private final RestTemplate restTemplate = new RestTemplate();

    private final Environment env;

    public ClientController(Environment env) {
        this.env = env;
    }

    @GetMapping("greeting/{name}")
    public String hi(@PathVariable String name) {
        return restTemplate.getForObject(env.getRequiredProperty("server.url") + name,
                String.class);
    }
}
