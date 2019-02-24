package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.PlayerTeamsService;
import com.pk.fantasyekstraklasa.persistence.model.PlayerTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playerTeams")
public class PlayerTeamsController {

    private PlayerTeamsService playerTeamsService;

    @Autowired
    public PlayerTeamsController(PlayerTeamsService playerTeamsService) {
        this.playerTeamsService = playerTeamsService;
    }

    @RequestMapping(value = "/{playerTeamId}/removePlayerFromFirstSquad", method = RequestMethod.PATCH)
    public ResponseEntity<?> removePlayerFromFirstSquad(@PathVariable Long playerTeamId) {
        playerTeamsService.removePlayerFromFirstSquad(playerTeamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{playerTeamId}/addPlayerToFirstSquad", method = RequestMethod.PATCH)
    public ResponseEntity<?> addPlayerToFirstSquad(@PathVariable Long playerTeamId, @RequestBody String accuratePosition) {
        playerTeamsService.addPlayerToFirstSquad(playerTeamId, accuratePosition);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{playerInId}/{playerOutId}/substitutePlayers", method = RequestMethod.PATCH)
    public ResponseEntity<?> substitutePlayers(@PathVariable Long playerInId, @PathVariable Long playerOutId) {
        playerTeamsService.substitutePlayers(playerInId, playerOutId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{playerTeamId}/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> removePlayerFromTeam(@PathVariable Long playerTeamId) {
        System.out.println("playerTeamId: "+playerTeamId);
        List<PlayerTeam> players = new ArrayList<>(playerTeamsService.removePlayerFromTeam(playerTeamId));
        return players.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(players, HttpStatus.OK);
    }
}
