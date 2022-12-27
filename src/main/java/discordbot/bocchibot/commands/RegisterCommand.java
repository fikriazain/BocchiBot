package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discordbot.bocchibot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RegisterCommand implements MessageCommand {

    @Autowired
    private RegisterService registerService;

    @Override
    public String getName() {
        return "register";
    }

    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        String id = message.getInteraction().getUser().getId().asString();
        String username = message.getInteraction().getUser().getUsername();
        String discriminator = message.getInteraction().getUser().getDiscriminator();
        boolean register = registerService.registerUser(id, username, discriminator);
        if(register == true){
            return message.reply(String.format("Ah... Hello ... I'm Bocchi, nice to meet you %s",username));
        }
        else {
            return message.reply(String.format("Uhmm i thought i already know you %s", username));
        }
    }
}

