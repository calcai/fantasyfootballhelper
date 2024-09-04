package com.calvin.backend;


public record PlayerDTO(int playerId, String name, String team, int bye, int espnStandardRank, int espnHalfPprRank, int espnPprRank,
                        int sleeperStandardRank, int sleeperHalfPprRank, int sleeperPprRank, int yahooStandardRank, int yahooHalfPprRank, int yahooPprRank) {}
