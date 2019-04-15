package com.backend.crud.repository;

import com.backend.crud.model.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}
