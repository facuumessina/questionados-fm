package com.questionadosfm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questionadosfm.entity.Pregunta;
import com.questionadosfm.entity.Respuesta;

@Service
public class QuestionadosfmService {
	@Autowired
    PreguntaService preguntaService;

    public Pregunta bringRandomQuestion() {

        List<Pregunta> todasLasPreguntas = preguntaService.bringQuestions();
        int min = 1;
        int max = todasLasPreguntas.size();
        int random = (int) (Math.random() * ((max - min) +1)) + min;

        return todasLasPreguntas.get(random - 1);   
    }
    public boolean verifyAnswer(Integer preguntaId, Integer respuestaId) {

        Pregunta pregunta = preguntaService.searchQuestionById(preguntaId);

        for(Respuesta respuesta : pregunta.getOpciones()) {

            if(respuesta.getRespuestaId().equals(respuestaId)) {
                return respuesta.isEsCorrecta();
            }
        }

        return false;
    }
}
