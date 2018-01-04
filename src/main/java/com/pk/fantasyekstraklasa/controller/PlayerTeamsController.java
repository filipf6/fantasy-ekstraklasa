package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.PlayerTeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playerTeams")
public class PlayerTeamsController {

    private PlayerTeamsService playerTeamsService;

    @Autowired
    public PlayerTeamsController(PlayerTeamsService playerTeamsService) {
        this.playerTeamsService = playerTeamsService;
    }

    @RequestMapping(value = "removePlayerFromFirstSquad/{playerTeamId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> removePlayerFromFirstSquad(@PathVariable Long playerTeamId) {
        playerTeamsService.removePlayerFromFirstSquad(playerTeamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "addPlayerToFirstSquad/{playerTeamId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> addPlayerToFirstSquad(@PathVariable Long playerTeamId) {
        playerTeamsService.addPlayerToFirstSquad(playerTeamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
