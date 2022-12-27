package discordbot.bocchibot.repository;

import discord4j.core.object.entity.User;
import discordbot.bocchibot.model.UserDiscord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscordUserRepository extends JpaRepository<UserDiscord, String> {
    UserDiscord findByUserId(String userId);
}
