package com.calvin.backend.controller;

import com.calvin.backend.PlayerDTO;
import com.calvin.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayerDTOs() {
        List<PlayerDTO> playerDTOs = playerService.getAllPlayerDTOs();
        return new ResponseEntity<>(playerDTOs, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PlayerDTO>> getPlayerDTOByName(@PathVariable String name) {
        try {
            List<PlayerDTO> playerDTO = playerService.getPlayerDTOByName(name);
            return new ResponseEntity<>(playerDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/position/{position}")
    public ResponseEntity<List<PlayerDTO>> getPlayerDTOByPosition(@PathVariable String position) {
        try {
            List<PlayerDTO> playerDTOs = playerService.getPlayerDTOByPosition(position);
            return new ResponseEntity<>(playerDTOs, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
