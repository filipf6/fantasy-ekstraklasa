package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.TeamsService;
import com.pk.fantasyekstraklasa.logic.UsersService;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.model.PlayerTeam;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.utils.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/teams")
public class TeamsController {
    private TeamsService teamsService;
    private JwtTokenUtil jwtTokenUtil;
    private UsersService usersService;

    @Autowired
    public TeamsController(TeamsService teamsService, JwtTokenUtil jwtTokenUtil, UsersService usersService) {
        this.teamsService = teamsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.usersService = usersService;
    }

    @RequestMapping(value = "/{teamId}/addPlayer/{playerId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> addPlayerToTheTeam(@PathVariable Long teamId, @PathVariable Long playerId) {
        teamsService.addPlayerToTheTeam(teamId, playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{teamId}/players", method = RequestMethod.GET)
    public ResponseEntity<?> getPlayers(@PathVariable Long teamId) {
        //teamsService.getPlayersFromTeam(teamId).forEach(x-> System.out.println(x));
        List<PlayerTeam> players = new ArrayList<>(teamsService.getPlayersFromTeam(teamId)); //teamsService.getPlayersFromTeam(teamId)
        //players.forEach(p-> System.out.println(p));
        return players.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<Object>(players, HttpStatus.OK);
    }

    @RequestMapping(value="/saveTeam", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveTeam(@RequestBody Team team, @RequestHeader(value="Authorization") String token) {
        //System.out.println("teammm: "+team);
        token = token.substring(7);
        String email = jwtTokenUtil.getUsernameFromToken(token);
        Team savedTeam = usersService.setUsersTeam(email,team);
        return new ResponseEntity<Object>(savedTeam, HttpStatus.OK);
    }
}
