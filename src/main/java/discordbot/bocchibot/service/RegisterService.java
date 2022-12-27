package discordbot.bocchibot.service;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;

public interface RegisterService {
    boolean registerUser(String id, String username, String discriminator);
}
