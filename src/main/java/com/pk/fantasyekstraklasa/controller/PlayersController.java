package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.PlayersService;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayersController {
    private PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addPlayer(@RequestBody Player player) {
        Player savedPlayer = playersService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> searchPlayers(@RequestParam("searchValue") String searchValue) {
        System.out.println("searchValue: "+searchValue);
        List<Player> players = playersService.searchPlayers(searchValue);
        return players.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(players, HttpStatus.OK);
    }
}
