package com.pk.fantasyekstraklasa.controller;

import com.pk.fantasyekstraklasa.logic.UsersService;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.User;
import com.pk.fantasyekstraklasa.utils.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UsersController {

//    @Value("${jwt.header}")
//    private String tokenHeader;
    private UsersService usersService;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public UsersController(UsersService usersService, JwtTokenUtil jwtTokenUtil) {
        this.usersService = usersService;
        this.jwtTokenUtil = jwtTokenUtil;
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

    @RequestMapping(value = "/team", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTeam(@RequestHeader(value="Authorization") String token) {
//        String token = request.getHeader(tokenHeader);
        System.out.println("token: "+token);

        token = token.substring(7);
        String email = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("hemail: " + email);
        Team team = usersService.getTeamByEmail(email);

        System.out.println(team);
        if(team==null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(team, HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
