package discordbot.bocchibot.Modal;

import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import discord4j.core.object.component.TextInput;
import discordbot.bocchibot.event.ModalSubmitListener;
import discordbot.bocchibot.service.GoogleSheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Array;
import java.util.ArrayList;

@Component
public class ModalSubmit implements ModalInterface{

    @Autowired
    private GoogleSheetsService googleSheetsService;

    @Override
    public String getId() {
        return "ModelForm";
    }

    @Override
    public Mono<Void> response(ModalSubmitInteractionEvent request) throws GeneralSecurityException, IOException {

        ArrayList<String> values = new ArrayList<String>();

        for (TextInput component : request.getComponents(TextInput.class)) {
            values.add(component.getValue().get());
        }
        googleSheetsService.appendData(values.get(0), values.get(1), values.get(2));
        return request.reply("Your data has been submitted");
    }
}
