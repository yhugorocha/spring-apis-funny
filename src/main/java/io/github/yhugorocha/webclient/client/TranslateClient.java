package io.github.yhugorocha.webclient.client;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import org.springframework.stereotype.Component;

@Component
public class TranslateClient {

    public String translate(String message) {
        String authKey = "12ba7386-9e29-4ec9-b0fe-e90832cd935e:fx";

        Translator translator = new Translator(authKey);

        TextResult result = null;
        try {
            result = translator.translateText(message, null, "pt-BR");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result.getText();
    }
}
