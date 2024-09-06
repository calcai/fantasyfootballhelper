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

    public PlayerDTO getPlayerDTOByName(String name) {
        Player player = playerRepository.findOne(PlayerSpecifications.hasName(name))
            .orElseThrow(() -> new RuntimeException("Player not found with name: " + name));
        
        return convertToDTO(player);
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
            player.getName(),
            player.getTeam(),
            player.getBye(),
            espn != null ? espn.getStandardRank() : 0,
            espn != null ? espn.getHalfPprRank() : 0,
            espn != null ? espn.getPprRank() : 0,
            sleeper != null ? sleeper.getStandardRank() : 0,
            sleeper != null ? sleeper.getHalfPprRank() : 0,
            sleeper != null ? sleeper.getPprRank() : 0,
            yahoo != null ? yahoo.getStandardRank() : 0,
            yahoo != null ? yahoo.getHalfPprRank() : 0,
            yahoo != null ? yahoo.getPprRank() : 0
        );
    }
}
