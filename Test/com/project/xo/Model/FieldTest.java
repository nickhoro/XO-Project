package com.project.xo.Model;

import com.project.xo.Model.Exceptions.AlreadyOccupiedException;
import com.project.xo.Model.Exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void getSizeTest() {
        final Field field = new Field();

        assertEquals(3, field.getSize());
    }

    @Test
    public void setFigureTest() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void setFigureWhenAlreadyOccupiedTest() throws AlreadyOccupiedException, InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        try {
            field.setFigure(inputPoint, inputFigure);
            fail();
        } catch (AlreadyOccupiedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenFigureIsNotSetTest() throws InvalidPointException {
        final Field field = new Field();
        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void getFigureWhenXLessThenZeroTest(){
        final Field field = new Field();
        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenXBiggerThanSizeTest(){
        final Field field = new Field();
        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenYLessThenZeroTest(){
        final Field field = new Field();
        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFigureWhenYBiggerThanSizeTest(){
        final Field field = new Field();
        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (InvalidPointException e) {
            e.printStackTrace();
        }
    }

    /**
     * Также нужно написать тесты для оюоих случаев, когда X и Y оба больше Size или менше 0
     */
}