package com.questionadosfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionadosfm.entity.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Integer> {

}
