package Game;
import ConsoleInput.Console;
import Players.Player;
import Questions.GeneratePoolOfQuestion;
import Questions.PoolOfQuestions;
import Questions.Question;

public class LaunchGame {
    int numberOfPlayers;
    Player [] player;
    GeneratePoolOfQuestion questions;
    Question[] currentPoolForTheGame;



    {
        System.out.println("Welcome in quiz game!");
        numberOfPlayers = Console.getIntInput("Please set number of players: ");
        player = new Player[numberOfPlayers];
//        questions = new PoolOfQuestions();
    }

    public LaunchGame(GeneratePoolOfQuestion questions){
        this.questions = new PoolOfQuestions();
    }


    public void addPlayerToList(){
        System.out.println("There will be " + numberOfPlayers + " " + (numberOfPlayers>1?"players":"player"));
        for(int i = 0; i<numberOfPlayers; i++){
            String name = Console.getStringInput("Provide name of player " + (i+1));
            player[i]=new Player(1+i,name);
        }
    }

    public void test(){
        currentPoolForTheGame = questions.generateUniqePool();
        for(Question question: currentPoolForTheGame){
            System.out.println(question);
        }
    }

}
