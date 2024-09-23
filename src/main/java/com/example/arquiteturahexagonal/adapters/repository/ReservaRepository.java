package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {
}
