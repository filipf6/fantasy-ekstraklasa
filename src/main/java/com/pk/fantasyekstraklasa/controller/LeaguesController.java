package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.LeaguesService;
import com.pk.fantasyekstraklasa.persistence.model.League;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leagues")
public class LeaguesController {
    private LeaguesService leaguesService;

    @Autowired
    public LeaguesController(LeaguesService leaguesService) {
        this.leaguesService = leaguesService;
    }

    @RequestMapping(value = "/addLeague", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addLeague(League league) {
        League savedLeague = leaguesService.addLeague(league);
        return new ResponseEntity<>(savedLeague, HttpStatus.OK);
    }

    @RequestMapping(value = "{leagueId}/addTeam/{teamId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> addTeamToTheLeague(@PathVariable Long leagueId, @PathVariable Long teamId) {
        leaguesService.addTeamToTheLeague(leagueId, teamId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
