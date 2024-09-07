package com.calvin.backend;

import java.util.Optional;

public record PlayerDTO(
    int playerId, 
    String firstName,
    String lastName, 
    String team, 
    int bye, 
    String position,
    Optional<Integer> espnStandardRank, 
    Optional<Integer> espnHalfPprRank, 
    Optional<Integer> espnPprRank, 
    Optional<Integer> sleeperStandardRank, 
    Optional<Integer> sleeperHalfPprRank, 
    Optional<Integer> sleeperPprRank, 
    Optional<Integer> yahooStandardRank, 
    Optional<Integer> yahooHalfPprRank, 
    Optional<Integer> yahooPprRank
) {}
