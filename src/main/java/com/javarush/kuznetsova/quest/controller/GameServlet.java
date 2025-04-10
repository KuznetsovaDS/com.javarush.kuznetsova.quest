package com.javarush.kuznetsova.quest.controller;

import com.javarush.kuznetsova.quest.model.Question;
import com.javarush.kuznetsova.quest.repo.GameRepo;
import com.javarush.kuznetsova.quest.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    private final GameService  gameService;

    public GameServlet() {
        this(new GameService(GameRepo.getGameRepo()));
    }

    //для тестов
    public GameServlet(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        //счетчик
        Integer playedGames = (Integer) httpSession.getAttribute("playedGames");
        if(playedGames == null){
            playedGames = 0;
        }

        String userName = (String) httpSession.getAttribute("userName");
        if(userName == null){
            userName = req.getParameter("userName");
        }
        if (userName != null){
            httpSession.setAttribute("userName", userName);
        }

        req.setAttribute("sessionId", httpSession.getId());

        Long questionId = 1L;
        String questionIdParam = req.getParameter("questionId");

        if(questionIdParam != null){
            questionId = Long.parseLong(questionIdParam);
        }

        Question question = gameService.getQuestionById(questionId);

        if(question.getAnswers().isEmpty()){
            playedGames++;
            httpSession.setAttribute("playedGames", playedGames);
            req.setAttribute("text", question.getText());
            req.setAttribute("isWinning", question.getIsWinning());
            req.getRequestDispatcher("/result.jsp").forward(req,resp);
            return;
        }
        req.setAttribute("question", question);
        req.getRequestDispatcher("/game.jsp").forward(req,resp);
    }
}
