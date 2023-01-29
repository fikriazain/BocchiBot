package discordbot.bocchibot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class BocchiBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(BocchiBotApplication.class, args);
    }
}
