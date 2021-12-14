package com.questionadosfm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionadosfm.entity.Pregunta;
import com.questionadosfm.models.request.RespuestaAVerificar;
import com.questionadosfm.models.response.RespuestaVerific;
import com.questionadosfm.service.QuestionadosfmService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/questionadosfm")
public class QuestionadosController {

	@Autowired
	QuestionadosfmService questionadosService;

	@GetMapping("/next")
	public ResponseEntity<Pregunta> traerPreguntaRandom() {
		Pregunta proximaPregunta = questionadosService.traerPreguntaRandom();
		return ResponseEntity.ok(proximaPregunta);
	}

	@PostMapping("/verificaciones")
	public ResponseEntity<RespuestaVerific> verificarRespuesta(
			@RequestBody RespuestaAVerificar respuestaAVerificar) {
		RespuestaVerific respuestaVerificada = new RespuestaVerific();
		if (questionadosService.verificarRespuesta(respuestaAVerificar.preguntaId, respuestaAVerificar.respuestaId)) {
			respuestaVerificada.esCorrecta = true;
		} else {
			respuestaVerificada.esCorrecta = false;
		}
		return ResponseEntity.ok(respuestaVerificada);
	}
}
