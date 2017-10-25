package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.controller.errorHandling.customExceptions.NotFoundException;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.User;
import com.pk.fantasyekstraklasa.persistence.repository.TeamsRepository;
import com.pk.fantasyekstraklasa.persistence.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private UsersRepository usersRepository;
    private TeamsRepository teamsRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository, TeamsRepository teamsRepository) {
        this.usersRepository = usersRepository;
        this.teamsRepository = teamsRepository;
    }

    public User saveUser(User user) {
        return usersRepository.save(user);
    }

    public User getUserById(Long id) {
        User user = usersRepository.findOne(id);
        if (user == null) throw new NotFoundException();
        return user;
    }

    public void setUsersTeam(Long userId, Team team) {
        teamsRepository.save(team);
        User user = usersRepository.findOne(userId);
        if (user == null) throw new NotFoundException();
        user.setTeam(team);
        usersRepository.saveAndFlush(user);
    }
}
