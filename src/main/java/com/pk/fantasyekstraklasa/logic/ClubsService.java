package com.pk.fantasyekstraklasa.logic;

import com.pk.fantasyekstraklasa.persistence.model.Club;
import com.pk.fantasyekstraklasa.persistence.repository.ClubsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubsService {
    private ClubsRepository clubsRepository;

    @Autowired
    public ClubsService(ClubsRepository clubsRepository) {
        this.clubsRepository = clubsRepository;
    }

    public Club addClub(Club club) {
        return clubsRepository.save(club);
    }
}
