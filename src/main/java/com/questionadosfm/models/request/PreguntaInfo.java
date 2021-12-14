package com.questionadosfm.models.request;

import java.util.List;

import com.questionadosfm.entity.Respuesta;

public class PreguntaInfo {
	public String enunciado;
	public List<Respuesta> opciones;
	public Integer categoriaId;
}
