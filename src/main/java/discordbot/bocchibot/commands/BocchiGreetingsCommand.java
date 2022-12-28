package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class BocchiGreetingsCommand implements MessageCommand {
    @Override
    public String getName() {
        return "greetbocchi";
    }
    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        message.getInteraction().getChannel().flatMap(messageChannel -> messageChannel.createMessage("B..B..BOCCHI DESU")).subscribe();
        return message.reply("https://tenor.com/view/bocchi-bocchi-the-rock-happy-bocchi-the-rock-bocchi-anime-happy-bocchi-anime-gif-26976538");
    }
}
