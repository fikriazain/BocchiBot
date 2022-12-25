package discordbot.bocchibot.service;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<Void> response(ChatInputInteractionEvent message);
}
