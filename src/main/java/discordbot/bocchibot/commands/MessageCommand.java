package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

public interface MessageCommand {
    String getName();
    Mono<Void> response(ChatInputInteractionEvent message);
}
