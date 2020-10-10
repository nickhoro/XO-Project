package com.project.xo.View;

import com.project.xo.Controllers.CurrentMoveController;
import com.project.xo.Controllers.MoveController;
import com.project.xo.Controllers.WinnerController;
import com.project.xo.Model.Exceptions.AlreadyOccupiedException;
import com.project.xo.Model.Exceptions.InvalidPointException;
import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;
import com.project.xo.Model.Game;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    public void show(final Game game) {
        final Field field = game.getField();

        System.out.printf("Game name: %s\n", game.getName());

        for (int i = 0; i < field.getSize(); i++) {
            if (i != 0) {
                printSeparator();
            }

            printLine(field, i);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);

        if (winner != null) {
            System.out.printf("Winner is: %s\n", winner);
            return false;
        }

        final Figure currentFigure = currentMoveController.currentMove(field);

        if (currentFigure == null) {
            System.out.println("No winner and no move left!");
            return false;
        }

        System.out.printf("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();

        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
//            e.printStackTrace();
            System.out.println("Point is invalid!");
        }

        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("x: ") - 1, askCoordinate("y: ") - 1);
    }

    private int askCoordinate(final String coordinate) {
        final Scanner scanner = new Scanner(System.in);
        System.out.format("Please input %s", coordinate);

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Idiot!?");
            return askCoordinate(coordinate);
        }
    }

    private void printLine(final Field field, final int i) {
        for (int j = 0; j < field.getSize(); j++) {
            if (j != 0) {
                System.out.print(" | ");
            }

            final Figure figure;
            try {
                figure = field.getFigure(new Point(j, i));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }

            System.out.print(figure != null ? figure : " ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("----------");
    }
}
