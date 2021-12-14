package com.questionadosfm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionadosfm.entity.Categoria;
import com.questionadosfm.models.response.RespuestaGenerica;
import com.questionadosfm.service.CategoriaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> traerCategorias() {
		return ResponseEntity.ok(categoriaService.traerCategorias());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> traerCategoriaPorId(@PathVariable Integer id) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		if (categoriaService.existePorId(id)) {
			return ResponseEntity.ok(categoriaService.buscarCategoriaPorId(id));
		} else {
			respuesta.isOk = false;
			respuesta.message = "The category doesn't exist";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	@PostMapping
	public ResponseEntity<?> crearCategoria(@RequestBody Categoria categoria) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		if (categoriaService.crearCategoria(categoria)) {
			respuesta.id = categoria.getCategoriaId();
			respuesta.isOk = true;
			respuesta.message = "Category created successfully";
			return ResponseEntity.ok(respuesta);
		} else {
			respuesta.isOk = false;
			respuesta.message = "The category was already created";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCategoriaPorId(@PathVariable Integer id) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		if (categoriaService.eliminarCategoriaPorId(id)) {
			respuesta.isOk = true;
			respuesta.message = "The category was deleted";
			return ResponseEntity.ok(respuesta);
		} else {
			respuesta.isOk = false;
			respuesta.message = "An error has occurred";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}
}
