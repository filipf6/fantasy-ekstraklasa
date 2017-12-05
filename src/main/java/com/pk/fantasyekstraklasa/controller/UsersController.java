package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.UsersService;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveUser(User userToSave) {
        //User savedUser =
                usersService.saveUser(userToSave);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        User user = usersService.getUserById(userId);
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
//        User user = usersService.getUserByEmail(email);
//        return new ResponseEntity<Object>(user, HttpStatus.OK);
//    }

//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> getUserByUsername(@RequestParam String username) {
//        User user = usersService.getUserByUsername(username);
//        return new ResponseEntity<Object>(user, HttpStatus.OK);
//    }

    @RequestMapping(value = "/{userId}/setTeam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setTeam(Team team, @PathVariable Long userId) {
        usersService.setUsersTeam(userId, team);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
