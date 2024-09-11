package se.systementor.containerize2.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakePlayerRepository {
    private final static List<Player> players = new ArrayList<>( Arrays.asList(
            Player.builder().id(1).jerseyNumber(21).born(1973).playerName("Peter Forsberg").teamName("Colorado").build(),
            Player.builder().id(2).jerseyNumber(13).born(1971).playerName("Mats Sundin").teamName("Toronto").build(),
            Player.builder().id(3).jerseyNumber(5).born(1970).playerName("Niklas Lidström").teamName("Detroit").build()
    ) );

    public List<Player> findAll() {
        return players;
    }
}
