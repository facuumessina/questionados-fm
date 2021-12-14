package com.questionadosfm.models.response;

import java.util.ArrayList;
import java.util.List;

import com.questionadosfm.entity.Categoria;
import com.questionadosfm.entity.Pregunta;
import com.questionadosfm.entity.Respuesta;

public class ResolverPregunta {
	public Integer preguntaId;
    public String enunciado;
    public Categoria categoria;
    public List<PreguntaOpcion> opciones = new ArrayList<>();

    public static ResolverPregunta convertirDesde(Pregunta pregunta) {
        
        ResolverPregunta preguntaAResolver = new ResolverPregunta();

        preguntaAResolver.preguntaId = pregunta.getPreguntaId();
        preguntaAResolver.enunciado = pregunta.getEnunciado();
        preguntaAResolver.categoria = pregunta.getCategoria();
        
        preguntaAResolver.opciones = new ArrayList<>();

        for(Respuesta respuesta : pregunta.getOpciones()) {

            PreguntaOpcion opcion = new PreguntaOpcion();

            opcion.respuestaId = respuesta.getRespuestaId();
            opcion.texto = respuesta.getTexto();

            preguntaAResolver.opciones.add(opcion);
        }

        return preguntaAResolver;
    }
}
