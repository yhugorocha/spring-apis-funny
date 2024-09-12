package io.github.yhugorocha.webclient.controller;

import io.github.yhugorocha.webclient.client.TranslateClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslatorController {

    private final TranslateClient translateClient;

    public TranslatorController(TranslateClient translateClient) {
        this.translateClient = translateClient;
    }

    @GetMapping()
    public ResponseEntity<String> translate(@RequestParam(value = "text", required = true) String text){
        return ResponseEntity.ok(translateClient.translate(text));
    }
}
