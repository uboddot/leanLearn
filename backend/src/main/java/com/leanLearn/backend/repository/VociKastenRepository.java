package com.leanLearn.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanLearn.backend.model.VociKasten;

public interface VociKastenRepository extends JpaRepository<VociKasten, String> {

    Optional<VociKasten> findByLevel(int i);

    /**
     * Find the lowest level VociKasten in the database.
     * 
     * @return An Optional containing the lowest level VociKasten, or an empty
     *         Optional if none exist.
     */
    Optional<VociKasten> findFirstByOrderByLevelAsc();

}
