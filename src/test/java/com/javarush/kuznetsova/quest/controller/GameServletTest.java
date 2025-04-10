package com.javarush.kuznetsova.quest.controller;

import com.javarush.kuznetsova.quest.model.Answer;
import com.javarush.kuznetsova.quest.model.Question;
import com.javarush.kuznetsova.quest.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class GameServletTest {

    private GameServlet gameServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession httpSession;
    private RequestDispatcher dispatcher;
    private GameService gameService;

    @BeforeEach
    void setUp(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        httpSession = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);
        gameService = mock(GameService.class);

        when(request.getSession()).thenReturn(httpSession);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        gameServlet = new GameServlet(gameService);
    }

    @Test
    void gameCounterIncrementsGet() throws ServletException, IOException {
        when(request.getParameter("questionId")).thenReturn("8");
        Question question = new Question(8L,"Конец игры", new ArrayList<>(),true);
        when(gameService.getQuestionById(8L)).thenReturn(question);

        when(httpSession.getAttribute("playedGames")).thenReturn(2);
        gameServlet.doGet(request,response);
        verify(httpSession).setAttribute("playedGames", 3);
    }
    @Test
    void flagIsWinningAndTextControlGet() throws ServletException, IOException {
        when(request.getParameter("questionId")).thenReturn("8");
        Question question = new Question(8L,"Конец игры", new ArrayList<>(),true);
        when(gameService.getQuestionById(8L)).thenReturn(question);
        gameServlet.doGet(request,response);

        verify(request).setAttribute("text", "Конец игры");
        verify(request).setAttribute("isWinning", true);
    }
    @Test
    void forwardToResultPageGet() throws ServletException, IOException {
        when(request.getParameter("questionId")).thenReturn("8");
        Question question = new Question(8L,"Конец игры", new ArrayList<>(),true);
        when(gameService.getQuestionById(8L)).thenReturn(question);
        gameServlet.doGet(request,response);

        verify(request).getRequestDispatcher("/result.jsp");
        verify(dispatcher).forward(request,response);
    }
    @Test
    void gameStartsWithFirstQuestion() throws ServletException, IOException {
        when(request.getParameter("questionId")).thenReturn(null);
        List<Answer> answerList = List.of(new Answer(1L,"Ответ 1", 3L));
        Question question = new Question(1L,"Первый вопрос", answerList,false);

        when(gameService.getQuestionById(1L)).thenReturn(question);
        gameServlet.doGet(request,response);

        verify(gameService).getQuestionById(1L);
    }
}