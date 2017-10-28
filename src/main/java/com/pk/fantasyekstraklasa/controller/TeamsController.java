package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.TeamsService;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamsController {
    private TeamsService teamsService;

    @Autowired
    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @RequestMapping(value = "{teamId}/addPlayer/{playerId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> addPlayerToTheTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        teamsService.addPlayerToTheTeam(teamId, playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "{teamId}/players", method = RequestMethod.GET)
    public ResponseEntity<?> getPlayers(@PathVariable Long teamId) {
        List<Player> players = new ArrayList<>(teamsService.getPlayersFromTeam(teamId)); //teamsService.getPlayersFromTeam(teamId)

        return players.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<Object>(players, HttpStatus.OK);
    }
}
