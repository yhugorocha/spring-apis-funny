package io.github.yhugorocha.webclient.client;

import io.github.yhugorocha.webclient.dto.harry.HarryPotterCharacterResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Service
public class HarryPotterClient {

    private final WebClient client;

    public HarryPotterClient(WebClient.Builder webClient) {
        this.client = webClient.baseUrl("https://hp-api.onrender.com/api/").build();
    }

    public Flux<HarryPotterCharacterResponse> findAll(){
        return client.get()
                .uri("characters")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(HarryPotterCharacterResponse.class);
    }

    public Flux<HarryPotterCharacterResponse> findCharacterById(UUID id){
        return client.get()
                .uri("character/"+id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(HarryPotterCharacterResponse.class);
    }


}
