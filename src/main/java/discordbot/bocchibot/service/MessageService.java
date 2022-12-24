package discordbot.bocchibot.service;

import discord4j.core.object.entity.Message;

public interface MessageService {
    void response(Message message);
}
