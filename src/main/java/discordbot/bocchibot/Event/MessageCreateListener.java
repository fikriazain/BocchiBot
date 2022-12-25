package discordbot.bocchibot.event;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageCreateListener extends MessageListener implements EventListener<ChatInputInteractionEvent> {

    @Override
    public Class<ChatInputInteractionEvent> getEventType(){
        return ChatInputInteractionEvent.class;
    }

    @Override
    public Mono<Void> execute(ChatInputInteractionEvent event){
        return processMessage(event);
    }
}
