package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.ClubsService;
import com.pk.fantasyekstraklasa.persistence.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubsController {

    private ClubsService clubsService;

    @Autowired
    public ClubsController(ClubsService clubsService) {
        this.clubsService = clubsService;
    }

    @RequestMapping(value="/addClub", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addClub(@RequestBody Club club) {
        Club savedClub = clubsService.addClub(club);
        return new ResponseEntity<>(savedClub, HttpStatus.OK);
    }

    @RequestMapping(value = "{clubId}/addPlayer/{playerId}", method = RequestMethod.PATCH)
    public ResponseEntity<?> addPlayerToTheTeam(@PathVariable Long clubId, @PathVariable Long playerId) {
        //clubsService.addPlayerToTheClub(clubId, playerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
