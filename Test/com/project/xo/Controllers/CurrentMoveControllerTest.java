package com.project.xo.Controllers;

import com.project.xo.Model.Exceptions.InvalidPointException;
import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class CurrentMoveControllerTest {

    @Test
    public void currentMoveWhenNextMoveIsO() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);
            field.setFigure(new Point(i, 2), Figure.X);

            assertEquals(Figure.O, currentMoveController.currentMove(field));
        }
    }
    
    @Test
    public void currentMoveWhenNextMoveIsX() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(i, 0), Figure.X);
            field.setFigure(new Point(i, 1), Figure.O);

            assertEquals(Figure.X, currentMoveController.currentMove(field));
        }
    }

    @Test
    public void currentMoveWhenNoNextMove() throws InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);

            field.setFigure(new Point(0, 0), Figure.O);
            field.setFigure(new Point(0, 1), Figure.X);
            field.setFigure(new Point(0, 2), Figure.O);
            field.setFigure(new Point(1, 0), Figure.O);
            field.setFigure(new Point(1, 1), Figure.X);
            field.setFigure(new Point(1, 2), Figure.O);
            field.setFigure(new Point(2, 0), Figure.O);
            field.setFigure(new Point(2, 1), Figure.X);
            field.setFigure(new Point(2, 2), Figure.O);

            assertNull(currentMoveController.currentMove(field));
        }
    }
}