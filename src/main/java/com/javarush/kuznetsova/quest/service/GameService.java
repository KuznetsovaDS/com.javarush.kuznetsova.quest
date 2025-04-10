package com.javarush.kuznetsova.quest.service;

import com.javarush.kuznetsova.quest.model.Question;
import com.javarush.kuznetsova.quest.repo.GameRepo;

public class GameService {

    private final GameRepo gameRepo;

    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }
    public Question getQuestionById(Long id){
        return gameRepo.findQuestionById(id);
    }
}
