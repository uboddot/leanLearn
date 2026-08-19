package com.leanLearn.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leanLearn.backend.model.Voci;

public interface VociRepository extends JpaRepository<Voci, String> {
}
