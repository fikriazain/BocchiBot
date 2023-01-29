package discordbot.bocchibot.Modal;

import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import discord4j.core.object.component.TextInput;
import discordbot.bocchibot.event.ModalSubmitListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.sql.Array;
import java.util.ArrayList;

@Component
public class ModalSubmit implements ModalInterface{

    @Override
    public String getId() {
        return "ModelForm";
    }

    @Override
    public Mono<Void> response(ModalSubmitInteractionEvent request) {

        ArrayList<String> values = new ArrayList<String>();

        for (TextInput component : request.getComponents(TextInput.class)) {
            values.add(component.getValue().get());
        }
        return request.reply(String.format("Your name is %s and your NPM is %s", values.get(0), values.get(1)));
    }
}
