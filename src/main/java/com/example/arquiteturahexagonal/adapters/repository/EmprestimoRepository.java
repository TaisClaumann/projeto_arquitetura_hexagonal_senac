package com.example.arquiteturahexagonal.adapters.repository;

import com.example.arquiteturahexagonal.adapters.entities.EmprestimoEntity;
import com.example.arquiteturahexagonal.core.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {

    List<EmprestimoEntity> findByUsuarioEmprestimoId(Long usuarioEmprestimoId);
    List<EmprestimoEntity> findByLivroEmprestimoIdAndStatus(Long livroEmprestimoId, StatusEnum status);
}
