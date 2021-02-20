package com.servicos.appcpamaster.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicos.appcpamaster.domain.model.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}