package io.github.yhugorocha.webclient.controller;

import io.github.yhugorocha.webclient.client.HarryPotterClient;
import io.github.yhugorocha.webclient.dto.harry.HarryPotterCharacterResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.UUID;

@RestController
@RequestMapping("/harrypotter")
public class HarryPotterController {

    private final HarryPotterClient harryPotterClient;

    public HarryPotterController(HarryPotterClient harryPotterClient) {
        this.harryPotterClient = harryPotterClient;
    }

    @GetMapping("/characters")
    public ResponseEntity<Flux<HarryPotterCharacterResponse>> findCharacterById(){
        return ResponseEntity.ok(harryPotterClient.findAll());
    }

    @GetMapping("character/{id}")
    public ResponseEntity<Flux<HarryPotterCharacterResponse>> findCharacterById(@PathVariable UUID id){
        return ResponseEntity.ok(harryPotterClient.findCharacterById(id));
    }
}
