package discordbot.bocchibot.service;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discordbot.bocchibot.model.UserDiscord;
import discordbot.bocchibot.repository.DiscordUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private DiscordUserRepository discordUserRepository;

    @Override
    public boolean registerUser(String id, String username, String discriminator) {
        UserDiscord user = discordUserRepository.findByUserId(id);
        if(user == null){
            user = new UserDiscord();
            user.setUserId(id);
            user.setUserName(username);
            user.setUserDiscriminator(discriminator);
            discordUserRepository.save(user);
            return true;
        }
        return false;
    }

    public void meh(){
        //Make a function to print "something" based on certain time in real world


    }
}
