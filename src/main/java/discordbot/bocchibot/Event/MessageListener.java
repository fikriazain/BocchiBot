package discordbot.bocchibot.event;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.entity.Message;
import discordbot.bocchibot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;


public abstract class MessageListener {

    @Autowired
    MessageService messageService;

    public Mono<Void> processMessage(ChatInputInteractionEvent eventMessage){
        return Mono.defer(() -> messageService.response(eventMessage));
    }

}
