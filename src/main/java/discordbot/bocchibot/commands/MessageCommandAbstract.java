package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discordbot.bocchibot.repository.DiscordUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MessageCommandAbstract {

    @Autowired
    private DiscordUserRepository discordUserRepository;
    public boolean isRegisteredUser(ChatInputInteractionEvent message){
        String id = message.getInteraction().getUser().getId().asString();
        return discordUserRepository.findByUserId(id) != null;
    }
}
