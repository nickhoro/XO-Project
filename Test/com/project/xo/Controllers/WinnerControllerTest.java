package com.project.xo.Controllers;

import com.project.xo.Model.Exceptions.InvalidPointException;
import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    // Row tests
    @Test
    public void getWinnerWhenWinnerRowTest() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerRowTest() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);

            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerInFirstRowTest() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.O);
            field.setFigure(new Point(i, 1), Figure.X);
            field.setFigure(new Point(i, 2), Figure.O);

            assertNull(winnerController.getWinner(field));
        }
    }

// Column tests
    @Test
    public void getWinnerWhenWinnerColumnTest() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);

            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumnTest() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);

            assertNull(winnerController.getWinner(field));
        }
    }

// Diagonal tests
    @Test
    public void getWinnerWhenWinnerDiagonal1Test() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal1Test() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);

        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2Test() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);

        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal2Test() throws InvalidPointException {
        final WinnerController winnerController = new WinnerController();

        final Field field = new Field(3);

        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);

        assertNull(winnerController.getWinner(field));
    }
}