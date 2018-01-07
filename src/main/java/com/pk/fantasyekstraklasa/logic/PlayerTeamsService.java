package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.PlayerTeam;
import com.pk.fantasyekstraklasa.persistence.model.enums.AccuratePosition;
import com.pk.fantasyekstraklasa.persistence.repository.PlayerTeamRepository;
import com.pk.fantasyekstraklasa.utils.errorHandling.customExceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerTeamsService {

    private PlayerTeamRepository playerTeamRepository;

    @Autowired
    public PlayerTeamsService(PlayerTeamRepository playerTeamRepository) {
        this.playerTeamRepository = playerTeamRepository;
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

    }


}
