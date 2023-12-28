package com.example.tictactoe;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testStateCorrect() {
        List<String> tictactoe = Arrays.asList("X", "O", "X", "O", "X", "O", "X", "O", "X");
        Game game = new Game(true, false, "player1", "player2", "completed", "player1", 0, tictactoe);
        GameLogic gameLogic = new GameLogic(game);
        assertEquals(gameLogic.status, "completed");
        assertEquals(gameLogic.winner, "player1");
        assertEquals(gameLogic.checkResult(), 1);
    }

    @Test
    public void testStateDraw() {
        List<String> tictactoe = Arrays.asList("X", "O", "X", "O", "X", "O", "O", "X", "O");
        Game game = new Game(true, false, "player1", "player2", "completed", "draw", 0, tictactoe);
        GameLogic gameLogic = new GameLogic(game);
        assertEquals(gameLogic.status, "completed");
        assertEquals(gameLogic.winner, "draw");
        assertEquals(gameLogic.checkResult(), 3);
    }

    @Test
    public void testStateInProgress() {
        List<String> tictactoe = Arrays.asList("X", "O", "X", "O", "X", "O", "O", "X", "");
        Game game = new Game(true, false, "player1", "player2", "inProgress", "", 0, tictactoe);
        GameLogic gameLogic = new GameLogic(game);
        assertEquals(gameLogic.status, "inProgress");
        assertEquals(gameLogic.winner, "");
        assertEquals(gameLogic.checkResult(), 0);
    }
}
