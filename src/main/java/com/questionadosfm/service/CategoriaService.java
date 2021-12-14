package com.questionadosfm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionadosfm.entity.Categoria;
import com.questionadosfm.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public List<Categoria> bringCategory() {
		return categoriaRepository.findAll();
	}

	public Categoria searchCategoryById(Integer categoriaId) {
		Optional<Categoria> resultado = categoriaRepository.findById(categoriaId);
		Categoria categoria = null;
		if (resultado.isPresent()) {
			categoria = resultado.get();
		}
		return categoria;
	}

	public boolean createCategory(Categoria categoria) {
		if (exists(categoria.getNombre())) {
			return false;
		}
		categoriaRepository.save(categoria);
		return true;
	}

	public boolean existsById(int id) {
		Categoria categoria = categoriaRepository.findById(id);
		return categoria != null;
	}

	public boolean exists(String nombre) {
		Categoria categoria = categoriaRepository.findByNombre(nombre);
		return categoria != null;
	}

	public boolean deleteCategoryById(Integer id) {
		boolean res = false;
		if (existsById(id)) {
			categoriaRepository.deleteById(id);
			res = (!existsById(id));
		}
		return res;
	}
}
