package discordbot.bocchibot.model;

public class MessageSchedule {
    private String message;
    private String time;

    public MessageSchedule(String message, String time) {
        this.message = message;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }
}
