package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.PlayersService;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayersController {
    private PlayersService playersService;

    @Autowired
    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @RequestMapping(value = "/addPlayer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addPlayer(Player player) {
        Player savedPlayer = playersService.addPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }
}
