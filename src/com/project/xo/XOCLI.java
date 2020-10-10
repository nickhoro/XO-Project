package com.project.xo;

import com.project.xo.Model.Field;
import com.project.xo.Model.Figure;
import com.project.xo.Model.Game;
import com.project.xo.Model.Player;
import com.project.xo.View.ConsoleView;

public class XOCLI {

    public static void main(String[] args) {
        final String user1 = "Nick";
        final String user2 = "Bot";

        final Player[] players = new Player[2];
        players[0] = new Player(user1, Figure.X);
        players[1] = new Player(user2, Figure.O);

        final Game gameXO = new Game(players, new Field(3), "XO");

        final ConsoleView view  = new ConsoleView();

        view.show(gameXO);
        while (view.move(gameXO)) { //Пока есть след. ход
            view.show(gameXO);
        }
    }
}
