package se.systementor.containerize2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import se.systementor.containerize2.DTO.PlayerDTO;
import se.systementor.containerize2.models.FakePlayerRepository;

import java.util.List;
import java.util.Random;

@RestController
public class PlayerController {
    final FakePlayerRepository playerRepository;
    final Random rand = new Random();

    public PlayerController(FakePlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @GetMapping("/api/player")
    public List<PlayerDTO> players() {
        if(rand.nextInt(100) >= 95){
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "fejkar fel"
            );
        }
        return playerRepository
                .findAll()
                .stream()
                .map(player ->
                        PlayerDTO.builder()
                                .id(String.valueOf(player.getId()))
                                .playerName(player.getPlayerName())
                                .bornYear(player.getBorn())
                                .jersey(player.getJerseyNumber())
                                .teamName(player.getTeamName()).build()).toList();
    }


}
