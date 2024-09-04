package com.calvin.backend.specification;

import org.springframework.data.jpa.domain.Specification;

import com.calvin.backend.models.Player;

public class PlayerSpecifications {
    public static Specification<Player> hasPosition(String position) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("position"), position);
    }
    public static Specification<Player> hasName(String name) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("name"), name);
    }
    public static Specification<Player> hasTeam(String team) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("team"), team);
    }
}
