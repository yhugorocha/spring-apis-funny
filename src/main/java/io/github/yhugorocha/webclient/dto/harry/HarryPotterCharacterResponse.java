package io.github.yhugorocha.webclient.dto.harry;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;
import java.util.UUID;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record HarryPotterCharacterResponse(UUID id,
                                           String name,
                                           List<String> alternate_names,
                                           String species,
                                           String gender,
                                           String house,
                                           Boolean wizard,
                                           WandResponse wand,
                                           Boolean hogwartsStudent,
                                           Boolean hogwartsStaff,
                                           Boolean alive,
                                           String image) {
}
