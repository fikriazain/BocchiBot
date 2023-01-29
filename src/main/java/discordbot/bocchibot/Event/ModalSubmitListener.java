package discordbot.bocchibot.event;

import discord4j.core.GatewayDiscordClient;
import discordbot.bocchibot.Modal.ModalInterface;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import java.util.Collection;

@Component
public class ModalSubmitListener implements EventListener<ModalSubmitInteractionEvent>{

    private final Collection<ModalInterface> modal;

    public ModalSubmitListener(Collection<ModalInterface> modal, GatewayDiscordClient client) {
        this.modal = modal;
        client.on(ModalSubmitInteractionEvent.class, this::execute).subscribe();
    }

    @Override
    public Class<ModalSubmitInteractionEvent> getEventType() {
        return ModalSubmitInteractionEvent.class;
    }

    @Override
    public Mono<Void> execute(ModalSubmitInteractionEvent event) {
        return Flux.fromIterable(modal)
                .filter(modal -> modal.getId().equals(event.getCustomId()))
                .next()
                .flatMap(modal -> modal.response(event));
    }
}
