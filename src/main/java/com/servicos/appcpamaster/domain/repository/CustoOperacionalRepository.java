package com.servicos.appcpamaster.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicos.appcpamaster.domain.model.CustoOperacional;

@Repository
public interface CustoOperacionalRepository extends JpaRepository<CustoOperacional, Long>{

}
