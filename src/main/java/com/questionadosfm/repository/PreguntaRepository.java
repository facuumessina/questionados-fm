package com.questionadosfm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionadosfm.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

	Pregunta findById(int id);

	Pregunta findByEnunciado(String enunciado);
}