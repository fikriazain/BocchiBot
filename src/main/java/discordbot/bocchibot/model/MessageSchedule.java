package discordbot.bocchibot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "messageschedule")
public class MessageSchedule {
    @Id
    @Column(name = "messageId")
    private String messageId;

    @Column(name = "userIdSender")
    private String userIdsender;

    @Column(name = "userIdReceiver")
    private String userIdReceiver;

    @Column(name = "message")
    private String message;
}
