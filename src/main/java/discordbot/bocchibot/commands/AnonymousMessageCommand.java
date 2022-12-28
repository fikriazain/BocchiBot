package discordbot.bocchibot.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.object.command.ApplicationCommandInteractionOption;
import discord4j.core.object.command.ApplicationCommandInteractionOptionValue;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class AnonymousMessageCommand extends MessageCommandAbstract implements MessageCommand {

    @Override
    public String getName() {
        return "anonymous-message";
    }

    @Override
    public Mono<Void> response(ChatInputInteractionEvent message) {
        if(isRegisteredUser(message)){
            String message1 = message.getOption("message")
                    .flatMap(ApplicationCommandInteractionOption::getValue)
                    .map(ApplicationCommandInteractionOptionValue::asString)
                    .orElseThrow();

            message.getInteraction().getChannel().flatMap(messageChannel -> messageChannel.createMessage(String.format("%s",message1))).subscribe();
            return message.reply("I.. i... already sent it...").withEphemeral(true);
        }
        else {
            message.getInteraction().getChannel().flatMap(messageChannel -> messageChannel.createMessage("I don't know you ... please `/register`")).subscribe();
            return message.reply("https://tenor.com/view/bocchi-the-rock-bocchi-part-time-jobs-gif-27052191");
        }
    }
}
