package se.systementor.containerize2.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PlayerDTO {
    private String id;
    private int jersey;
    private String teamName;
    private String playerName;
    private int bornYear;
}
