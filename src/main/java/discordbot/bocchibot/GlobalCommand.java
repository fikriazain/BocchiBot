package discordbot.bocchibot;

import discord4j.discordjson.json.ApplicationCommandRequest;
import discord4j.rest.RestClient;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GlobalCommand implements ApplicationRunner {
    private final RestClient client;

    //Use the rest client provided by our Bean
    public GlobalCommand(RestClient client) {
        this.client = client;
    }
    @Override
    public void run(ApplicationArguments args) throws IOException {
        long applicationId = client.getApplicationId().block();
        ApplicationCommandRequest greetCmdRequest = ApplicationCommandRequest.builder()
                .name("greetbocchi")
                .description("She will happy if you greet her")
                .build();
        client.getApplicationService()
                .createGlobalApplicationCommand(applicationId, greetCmdRequest)
                .subscribe();

//      <---------- ADD NEW COMMENT HERE USING THIS COMMAND ---------->
//        ApplicationCommandRequest command1 = ApplicationCommandRequest.builder()
//                .name(NAME_COMMAND)
//                .description("DESCRIPTION COMMAND")
//                .build();
//        client.getApplicationService()
//                .createGlobalApplicationCommand(applicationId, command1)
//                .subscribe();
    }
}
