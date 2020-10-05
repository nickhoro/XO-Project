package com.project.xo.Controllers;

import com.project.xo.Model.Exceptions.AlreadyOccupiedException;
import com.project.xo.Model.Exceptions.InvalidPointException;
import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field, final Point point, final Figure figure) throws AlreadyOccupiedException, InvalidPointException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);
    }
}
