package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
}
