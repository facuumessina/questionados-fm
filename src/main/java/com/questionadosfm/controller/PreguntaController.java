package com.questionadosfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionadosfm.entity.Pregunta;
import com.questionadosfm.models.request.PreguntaInfo;
import com.questionadosfm.models.response.RespuestaGenerica;
import com.questionadosfm.service.PreguntaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/preguntas")
public class PreguntaController {
	@Autowired
	PreguntaService service;

	@GetMapping
	public ResponseEntity<List<Pregunta>> traerPreguntas() {
		return ResponseEntity.ok(service.traerPreguntas());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPreguntaPorId(@PathVariable Integer id) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		if (service.existePorId(id)) {
			return ResponseEntity.ok(service.buscarPreguntaPorId(id));
		} else {
			respuesta.isOk = false;
			respuesta.message = "The question doesn't exist";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	@PostMapping
	public ResponseEntity<?> crearPregunta(@RequestBody PreguntaInfo preguntaNueva) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		Pregunta pregunta = new Pregunta();
		if (service.crearPregunta(preguntaNueva.enunciado, preguntaNueva.categoriaId, preguntaNueva.opciones) != null) {
			respuesta.id = pregunta.getPreguntaId();
			respuesta.isOk = true;
			respuesta.message = "The question was successfully created";
			return ResponseEntity.ok(respuesta);
		} else {
			respuesta.isOk = false;
			respuesta.message = "The question already exists";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}
}
