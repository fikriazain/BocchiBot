package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MessageServiceImpl implements MessageCommand {
    @Override
    public String getName() {
        return "greetbocchi";
    }
    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        return message.reply("BOCCHI DESU!");
    }
}
