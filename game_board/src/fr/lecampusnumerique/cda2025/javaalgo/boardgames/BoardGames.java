package fr.lecampusnumerique.cda2025.javaalgo.boardgames;

import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Connect4Game;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.Games;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.GomokuGame;
import fr.lecampusnumerique.cda2025.javaalgo.boardgames.games.TicTacToeGame;

import java.util.Scanner;

public class BoardGames {
    private Games selectedGame;
    private final Games[] availableGames = new Games[]{Games.TICTACTOE, Games.CONNECT4, Games.GOMOKU};
    private final Scanner scanner = new Scanner(System.in);

    public BoardGames() {
    }

    public Games getSelectedGame() {
        return selectedGame;
    }

    private void setSelectedGame(Games selectedGame) {
        this.selectedGame = selectedGame;
    }

    public Games findGame(int number){
        for(Games game : Games.values()){
            if(game.ordinal() == number) {
                return game;
            }
        }
        return Games.TICTACTOE;
    }
    public void selectGame() {
        BoardGames boardGames = new BoardGames();
        System.out.println("Welcome to our boardgames platform. Which game do you want to play?");
        for (int i = 0; i < availableGames.length ; i++) {
            System.out.println("Press " + availableGames[i].ordinal() + " to play " + availableGames[i].getName());
        }

        int playerSelection = Integer.parseInt(scanner.nextLine());
        setSelectedGame(findGame(playerSelection));

        System.out.println("Perfect! Let's play " + getSelectedGame().getName());

        launchGame();
    }

    private void launchGame() {

        switch(selectedGame) {
            case Games.TICTACTOE:
                TicTacToeGame ticTacToeGame = new TicTacToeGame();
                ticTacToeGame.play(selectedGame);
                break;
            case Games.GOMOKU:
                GomokuGame gomokuGame = new GomokuGame();
                gomokuGame.play(selectedGame);
                break;
            case Games.CONNECT4:
                Connect4Game connect4Game = new Connect4Game();
                connect4Game.play(selectedGame);
                break;
            default:
                System.out.println("invalid selection");
        }
    }
}
