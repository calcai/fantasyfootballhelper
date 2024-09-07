package com.calvin.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calvin.backend.repository.EspnRepository;
import com.calvin.backend.repository.PlayerRepository;
import com.calvin.backend.repository.SleeperRepository;
import com.calvin.backend.repository.YahooRepository;
import com.calvin.backend.PlayerDTO;
import com.calvin.backend.models.*;
import com.calvin.backend.specification.PlayerSpecifications;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private EspnRepository espnRepository;

    @Autowired
    private SleeperRepository sleeperRepository;

    @Autowired
    private YahooRepository yahooRepository;

    public List<PlayerDTO> getAllPlayerDTOs() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayerDTOByName(String name) {
        List<Player> players = playerRepository.findAll(PlayerSpecifications.nameContains(name));
        return players.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<PlayerDTO> getPlayerDTOByPosition(String position) {
        List<Player> players = playerRepository.findAll(PlayerSpecifications.hasPosition(position));
        if (players.isEmpty()) {
            throw new RuntimeException("No players found with position: " + position);
        }
        return players.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PlayerDTO convertToDTO(Player player) {
        Espn espn = espnRepository.findById(player.getPlayerId()).orElse(null);
        Sleeper sleeper = sleeperRepository.findById(player.getPlayerId()).orElse(null);
        Yahoo yahoo = yahooRepository.findById(player.getPlayerId()).orElse(null);

        return new PlayerDTO(
            player.getPlayerId(),
            player.getFirstName(),
            player.getLastName(),
            player.getTeam(),
            player.getBye(),
            player.getPosition(),
            Optional.ofNullable(espn).map(Espn::getStandardRank),
            Optional.ofNullable(espn).map(Espn::getHalfPprRank),
            Optional.ofNullable(espn).map(Espn::getPprRank),
            Optional.ofNullable(sleeper).map(Sleeper::getStandardRank),
            Optional.ofNullable(sleeper).map(Sleeper::getHalfPprRank),
            Optional.ofNullable(sleeper).map(Sleeper::getPprRank),
            Optional.ofNullable(yahoo).map(Yahoo::getStandardRank),
            Optional.ofNullable(yahoo).map(Yahoo::getHalfPprRank),
            Optional.ofNullable(yahoo).map(Yahoo::getPprRank)
        );
    }
}
