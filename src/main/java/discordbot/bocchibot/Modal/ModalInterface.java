package discordbot.bocchibot.Modal;
import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface ModalInterface {
    String getId();
    Mono<Void> response(ModalSubmitInteractionEvent message) throws GeneralSecurityException, IOException;
}
