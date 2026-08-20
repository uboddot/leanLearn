package com.leanLearn.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanLearn.backend.model.VociKasten;

public interface VociKastenRepository extends JpaRepository<VociKasten, String> {

    Optional<VociKasten> findByLevel(int i);

}
