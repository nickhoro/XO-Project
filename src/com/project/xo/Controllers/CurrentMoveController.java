package com.project.xo.Controllers;

import com.project.xo.Model.Exceptions.InvalidPointException;
import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            countFigure += countFigureInTheRow(field, i);
        }

        if (countFigure == field.getSize() * field.getSize()) {
            return null;
        }

        if (countFigure % 2 == 0) {
            return Figure.X;
        }

        return Figure.O;
    }

    private int countFigureInTheRow(final Field field, final int row) {
        int countFigure = 0;

        for (int i = 0; i < field.getSize(); i++) {
            try {
                if (field.getFigure(new Point(i, row)) != null) {
                    countFigure++;
                }
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}
