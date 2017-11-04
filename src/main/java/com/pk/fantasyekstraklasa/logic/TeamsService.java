package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.utils.errorHandling.customExceptions.NotFoundException;
import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.Transfer;
import com.pk.fantasyekstraklasa.persistence.model.enums.TransferType;
import com.pk.fantasyekstraklasa.persistence.repository.PlayersRepository;
import com.pk.fantasyekstraklasa.persistence.repository.TeamsRepository;
import com.pk.fantasyekstraklasa.persistence.repository.TransfersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeamsService {
    private TeamsRepository teamsRepository;
    private PlayersRepository playersRepository;
    private TransfersRepository transfersRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository, PlayersRepository playersRepository, TransfersRepository transferRepository) {
        this.teamsRepository = teamsRepository;
        this.playersRepository = playersRepository;
        this.transfersRepository = transferRepository;
    }

    public void addPlayerToTheTeam(Long teamId, Long playerId) {
        Player player = playersRepository.findOne(playerId);
        Team team = teamsRepository.findOne(teamId);

        if (player == null || team == null) throw new NotFoundException();

        Set<Team> teams = player.getTeams();
        teams.add(team);
        player.setTeams(teams);

        Transfer transfer = new Transfer();
        transfer.setTransferType(TransferType.IN);
        transfer.setPlayer(player);
        transfer.setTeam(team);
        transfersRepository.saveAndFlush(transfer);
        playersRepository.saveAndFlush(player);

        //player.getTransfers().add(transfer);
        //Set<Team> teams = player.getTeams();
        //teams.add(team);
        //player.setTeams(teams);
        //team.getTransfers().add(transfer);
        //team.getPlayers().add(player);
        //playersRepository.saveAndFlush(player);
        //teamsRepository.saveAndFlush(team);
    }

    public Set<Player> getPlayersFromTeam(Long teamId) {
        Team team = teamsRepository.findOne(teamId);
        if (team == null) throw new NotFoundException();
        return team.getPlayers();
    }
}
