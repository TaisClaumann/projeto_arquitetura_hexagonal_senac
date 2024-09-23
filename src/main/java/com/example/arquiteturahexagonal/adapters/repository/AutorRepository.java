package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
}
