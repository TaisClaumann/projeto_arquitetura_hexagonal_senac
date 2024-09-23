package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
