package se.systementor.containerize2.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Player {
    private int id;
    private int jerseyNumber;
    private String teamName;
    private String playerName;
    private int born;
}
