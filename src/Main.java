import Game.LaunchGame;
import Questions.PoolOfQuestions;

public class Main {
    public static void main(String[] args) {
        LaunchGame startGame = new LaunchGame(new PoolOfQuestions());
        startGame.addPlayerToList();
        startGame.test();
        startGame.startGame();

    }
}