package discordbot.bocchibot.event;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discordbot.bocchibot.commands.MessageCommand;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Component
public class MessageCreateListener implements EventListener<ChatInputInteractionEvent> {

    private final Collection<MessageCommand> commands;

    public MessageCreateListener(Collection<MessageCommand> commands, GatewayDiscordClient client) {
        this.commands = commands;
        client.on(ChatInputInteractionEvent.class, this::execute).subscribe();
    }

    @Override
    public Class<ChatInputInteractionEvent> getEventType(){
        return ChatInputInteractionEvent.class;
    }

    @Override
    public Mono<Void> execute(ChatInputInteractionEvent eventMessage){
        System.out.println(commands);
        return Flux.fromIterable(commands)
                .filter(command -> command.getName().equals(eventMessage.getCommandName()))
                .next()
                .flatMap(command -> command.response(eventMessage));
    }
}
