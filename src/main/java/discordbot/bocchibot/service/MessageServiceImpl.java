package discordbot.bocchibot.service;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageServiceImpl implements MessageService{
    private static final String PREFIX_CHARACTER = "!";

    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        if(message.getCommandName().equals("greetbocchi")){
            return message.reply("BOCCHI DESU!");
        }
        return Mono.empty();
    }
}
