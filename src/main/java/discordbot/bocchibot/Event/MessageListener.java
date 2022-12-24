package discordbot.bocchibot.event;

import discord4j.core.object.entity.Message;
import discordbot.bocchibot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public abstract class MessageListener {

    @Autowired
    MessageService messageService;

    public Mono<Void> processMessage(Message eventMessage){
        return Mono.fromRunnable(() -> messageService.response(eventMessage));
    }

}
