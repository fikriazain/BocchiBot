package discordbot.bocchibot.commands;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.interaction.ModalSubmitInteractionEvent;
import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.TextInput;
import discord4j.core.spec.InteractionPresentModalSpec;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ModalDev extends MessageCommandAbstract implements MessageCommand {
    static final String MODAL_CUSTOM_ID = "ModelForm";
    static final String NAME_CUSTOM_ID = "nameId";
    static final String NPM_CUSTOM_ID = "npmId";
    private final GatewayDiscordClient client;

    public ModalDev(GatewayDiscordClient client) {
        this.client = client;
    }

    @Override
    public String getName() {
        return "modal";
    }

    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        InteractionPresentModalSpec.Builder modal = InteractionPresentModalSpec.builder();
        modal.title("Test MEH");
        modal.customId(MODAL_CUSTOM_ID);
        modal.addComponent(ActionRow.of(TextInput.small(NAME_CUSTOM_ID, "Name", 0, 400).required(true)));
        modal.addComponent(ActionRow.of(TextInput.small(NPM_CUSTOM_ID, "NPM", 10, 10).required(true)));
        message.presentModal(modal.build()).subscribe();
        return message.reply("");
    }
}
