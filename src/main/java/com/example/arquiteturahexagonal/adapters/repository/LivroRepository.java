package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}
