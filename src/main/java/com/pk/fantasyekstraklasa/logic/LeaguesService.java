package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.League;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.Transfer;
import com.pk.fantasyekstraklasa.persistence.repository.LeaguesRepository;
import com.pk.fantasyekstraklasa.persistence.repository.TeamsRepository;
import com.pk.fantasyekstraklasa.utils.errorHandling.customExceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LeaguesService {
    private LeaguesRepository leaguesRepository;
    private TeamsRepository teamsRepository;

    @Autowired
    public LeaguesService(LeaguesRepository leaguesRepository, TeamsRepository teamsRepository) {
        this.leaguesRepository = leaguesRepository;
        this.teamsRepository = teamsRepository;
    }

    public League addLeague(League league) {
        return leaguesRepository.saveAndFlush(league);
    }

    public void addTeamToTheLeague(Long leagueId, Long teamId) {
        Team team = teamsRepository.findOne(teamId);
        League league = leaguesRepository.findOne(leagueId);

        if (league == null || team == null) throw new NotFoundException();

        Set<League> leagues = team.getLeagues();
        leagues.add(league);
        team.setLeagues(leagues);

        teamsRepository.saveAndFlush(team);

//        Set<Team> teams = player.getTeams();
//        teams.add(team);
//        player.setTeams(teams);
//
//        Transfer transfer = new Transfer();
//        transfer.setTransferType(TransferType.IN);
//        transfer.setPlayer(player);
//        transfer.setTeam(team);
//        transfersRepository.saveAndFlush(transfer);
//        playersRepository.saveAndFlush(player);

    }
}
