package discordbot.bocchibot.service;

import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.User;
import discord4j.core.object.entity.channel.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
    private static final String PREFIX_CHARACTER = "!";

    @Override
    public void response(Message message) {
        String request = message.getContent();
        final MessageChannel channel = message.getChannel().block();
        if (message.getAuthor().map(user -> !user.isBot()).orElse(false) && request.startsWith(PREFIX_CHARACTER)) {
            channel.typeUntil(channel.createMessage("BOCCHI DESU!")).blockLast();
        }
    }
}
