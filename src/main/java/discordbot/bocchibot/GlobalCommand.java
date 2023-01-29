package discordbot.bocchibot;

import discord4j.core.object.command.ApplicationCommandOption;
import discord4j.discordjson.json.ApplicationCommandOptionData;
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
                .description("She'll be happy if you greet her")
                .dmPermission(true)
                .build();
        client.getApplicationService()
                .createGlobalApplicationCommand(applicationId, greetCmdRequest)
                .subscribe();

        ApplicationCommandRequest command2 = ApplicationCommandRequest.builder()
                .name("anonymous-message")
                .description("Send Anonymous Message")
                .addOption(ApplicationCommandOptionData.builder()
                        .name("message")
                        .description("Put your message here")
                        .type(ApplicationCommandOption.Type.STRING.getValue())
                        .required(true)
                        .build())
                .build();
        client.getApplicationService()
                .createGlobalApplicationCommand(applicationId, command2)
                .subscribe();

        ApplicationCommandRequest command3 = ApplicationCommandRequest.builder()
                .name("register")
                .description("Bocchi doesn't know you yet, please register yourself")
                .build();
        client.getApplicationService()
                .createGlobalApplicationCommand(applicationId, command3)
                .subscribe();
        ApplicationCommandRequest command4 = ApplicationCommandRequest.builder()
                .name("modal")
                .description("Test Modal")
                .build();
        client.getApplicationService()
                .createGlobalApplicationCommand(applicationId, command4)
                .subscribe();


//      <---------- ADD NEW COMMAND HERE USING THIS COMMENT ---------->
//        ApplicationCommandRequest command1 = ApplicationCommandRequest.builder()
//                .name(NAME_COMMAND)
//                .description("DESCRIPTION COMMAND")
//                .build();
//        client.getApplicationService()
//                .createGlobalApplicationCommand(applicationId, command1)
//                .subscribe();

//        <---------- DELETE COMMAND USING THIS COMMENT ---------->
//        client.getApplicationService()
//                .deleteGlobalApplicationCommand(applicationId, commandId)
//                .subscribe();

    }
}
