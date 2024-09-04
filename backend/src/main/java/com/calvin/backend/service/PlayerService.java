package com.calvin.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.calvin.backend.repository.PlayerRepository;
import com.calvin.backend.models.*;
import com.calvin.backend.specification.*;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }
    public Player searchPlayer(String name){
        return playerRepository.findAll(PlayerSpecifications.hasName(name)).get(1);
    }
    public Player getPlayersByPosition(String position){
        return playerRepository.findAll(PlayerSpecifications.hasPosition(position)).get(1);
    }
}