package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.PlayerTeam;
import com.pk.fantasyekstraklasa.persistence.model.Team;
import com.pk.fantasyekstraklasa.persistence.model.enums.AccuratePosition;
import com.pk.fantasyekstraklasa.persistence.repository.PlayerTeamRepository;
import com.pk.fantasyekstraklasa.persistence.repository.TeamsRepository;
import com.pk.fantasyekstraklasa.utils.errorHandling.customExceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlayerTeamsService {

    private PlayerTeamRepository playerTeamRepository;
    private TeamsRepository teamsRepository;

    @Autowired
    public PlayerTeamsService(PlayerTeamRepository playerTeamRepository, TeamsRepository teamsRepository) {
        this.playerTeamRepository = playerTeamRepository;
        this.teamsRepository = teamsRepository;
    }

    public void removePlayerFromFirstSquad(Long playerTeamId) {
        PlayerTeam playerTeam = playerTeamRepository.findOne(playerTeamId);
        if (playerTeam == null) throw new NotFoundException();
        playerTeam.setFirstSquad(false);
        playerTeam.setAccuratePosition(null);
        playerTeamRepository.saveAndFlush(playerTeam);
    }

    public void addPlayerToFirstSquad(Long playerTeamId, String accuratePosition) {
        PlayerTeam playerTeam = playerTeamRepository.findOne(playerTeamId);
        if (playerTeam == null) throw new NotFoundException();
        playerTeam.setFirstSquad(true);
        playerTeam.setAccuratePosition(AccuratePosition.buildAccuratePositionFromString(accuratePosition));
        playerTeamRepository.saveAndFlush(playerTeam);
    }

    public void substitutePlayers(Long playerInId, Long playerOutId) {
        PlayerTeam playerIn = playerTeamRepository.findOne(playerInId);
        PlayerTeam playerOut = playerTeamRepository.findOne(playerOutId);
        if (playerIn == null || playerOut == null) throw new NotFoundException();
        playerIn.setFirstSquad(true);
        playerIn.setAccuratePosition(playerOut.getAccuratePosition());
        playerOut.setFirstSquad(false);
        playerOut.setAccuratePosition(null);
        playerTeamRepository.saveAndFlush(playerOut);
        playerTeamRepository.saveAndFlush(playerIn);
    }

    public Set<PlayerTeam> removePlayerFromTeam(Long playerTeamId) {
        PlayerTeam playerTeam = playerTeamRepository.findOne(playerTeamId);
        playerTeamRepository.delete(playerTeamId);
        Team team = teamsRepository.findOne(playerTeam.getTeam().getId());
        if (team == null) throw new NotFoundException();
        Set<PlayerTeam> teamsPlayers = team.getTeamPlayers();
        if(teamsPlayers == null) {
            throw new NotFoundException();
        }
        return teamsPlayers;
    }


}
