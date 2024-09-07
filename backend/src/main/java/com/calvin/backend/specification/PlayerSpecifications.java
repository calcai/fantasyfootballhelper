package com.calvin.backend.specification;

import org.springframework.data.jpa.domain.Specification;
import com.calvin.backend.models.Player;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class PlayerSpecifications {
    public static Specification<Player> hasPosition(String position) {
        return (root, query, criteriaBuilder) ->
            criteriaBuilder.equal(root.get("position"), position);
    }

    public static Specification<Player> hasName(String name) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("firstName"), name);
    }

    public static Specification<Player> hasTeam(String team) {
        return (root, query, criteriaBuilder) -> 
            criteriaBuilder.equal(root.get("team"), team);
    }

    public static Specification<Player> nameContains(String keyword) {
        return (Root<Player> root, CriteriaQuery<?> query, CriteriaBuilder builder) -> {
            if (keyword == null || keyword.isEmpty()) {
                return builder.conjunction();
            }
            String pattern = "%" + keyword.toLowerCase() + "%";
            return builder.or(
                builder.like(builder.lower(root.get("firstName")), pattern),
                builder.like(builder.lower(root.get("lastName")), pattern)
            );
        };
    }
}
