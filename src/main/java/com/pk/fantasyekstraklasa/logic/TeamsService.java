package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.PlayerTeam;
import com.pk.fantasyekstraklasa.persistence.repository.PlayerTeamRepository;
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
    private PlayerTeamRepository playerTeamRepository;

    @Autowired
    public TeamsService(TeamsRepository teamsRepository, PlayersRepository playersRepository, TransfersRepository transferRepository, PlayerTeamRepository playerTeamRepository) {
        this.teamsRepository = teamsRepository;
        this.playersRepository = playersRepository;
        this.transfersRepository = transferRepository;
        this.playerTeamRepository = playerTeamRepository;
    }

    public Set<PlayerTeam> addPlayerToTheTeam(Long teamId, Long playerId) {
        Player player = playersRepository.findOne(playerId);
        Team team = teamsRepository.findOne(teamId);

        if (player == null || team == null) throw new NotFoundException();
        double price1 = team.getBudget()*10;
        double price2 = player.getPrice()*10;
        double newBudget = price1 - price2;
        newBudget/=10;
        team.setBudget(newBudget);
        PlayerTeam playerTeam = new PlayerTeam(player,team,false,false,false,null);
        Transfer transfer = new Transfer();
        transfer.setTransferType(TransferType.IN);
        transfer.setPlayer(player);
        transfer.setTeam(team);
        transfersRepository.saveAndFlush(transfer);
        playerTeamRepository.saveAndFlush(playerTeam);
        return team.getTeamPlayers();
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

    public Set<PlayerTeam> getPlayersFromTeam(Long teamId) {
        Team team = teamsRepository.findOne(teamId);
        if (team == null) throw new NotFoundException();
        Set<PlayerTeam> teamsPlayers = team.getTeamPlayers();
        if(teamsPlayers == null) {
            throw new NotFoundException();
        }
        return teamsPlayers;
    }

//    public Team saveTeam(Team team) {
//        return teamsRepository.save(team);
//    }
}
