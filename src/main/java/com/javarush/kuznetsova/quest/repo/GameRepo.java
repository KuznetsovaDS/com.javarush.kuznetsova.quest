package com.javarush.kuznetsova.quest.repo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.kuznetsova.quest.model.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GameRepo {

    private static GameRepo gameRepo;

    private final List<Question> questions = new ArrayList<>();

    private GameRepo(){
        loadQuestions();
    }

    public static GameRepo getGameRepo(){
        if(gameRepo == null){
            gameRepo = new GameRepo();
        }
        return gameRepo;
    }

    private void loadQuestions(){
        ObjectMapper objectMapper = new ObjectMapper();

        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("questions.json")){
            List<Question> loadedQuestions = objectMapper.readValue(inputStream, new TypeReference<>() {});
            questions.addAll(loadedQuestions);
        }
        catch (IOException e){
            throw new RuntimeException("Ошибка при загрузке вопросов");
        }
    }

    public Question findQuestionById(Long id){
        return questions.stream()
                .filter(question -> question.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
