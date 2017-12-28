package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.Player;
import com.pk.fantasyekstraklasa.persistence.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {
    private PlayersRepository playersRepository;

    @Autowired
    public PlayersService(PlayersRepository playersRepository) {
        this.playersRepository = playersRepository;
    }

    public Player addPlayer(Player player) {
        return playersRepository.save(player);
    }
}
