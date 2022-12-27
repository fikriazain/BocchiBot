package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AnonymousMessageCommand implements MessageCommand {

    @Override
    public String getName() {
        return "anonymous-message";
    }

    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {

        String message1 = message.getOption("message")
                .flatMap(ApplicationCommandInteractionOption::getValue)
                .map(ApplicationCommandInteractionOptionValue::asString)
                .orElseThrow();

        message.getInteraction().getChannel().flatMap(messageChannel -> messageChannel.createMessage(String.format("%s",message1))).subscribe();
        return message.reply("I.. i... already sent it...").withEphemeral(true);
    }
}
