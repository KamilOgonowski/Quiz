package Game;
import ConsoleInput.Console;
import Players.Player;
import Questions.GeneratePoolOfQuestion;
import Questions.PoolOfQuestions;
import Questions.Question;

import java.util.Arrays;

public class LaunchGame {
    int numberOfPlayers;
    Player [] player;
    GeneratePoolOfQuestion questions;
    Question[] currentPoolForTheGame;



    {
        System.out.println("Welcome in quiz game!");
        numberOfPlayers = Console.getIntInput("Please set number of players: ");
        player = new Player[numberOfPlayers];
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
//        for(Question question: currentPoolForTheGame){
//            System.out.println(question);
//        }
    }

    public void startGame(){
        boolean quitGame = false;
        System.out.println("We are staring the game. Each player will get a chance to answer and get points");
        for(int i = 0; i < currentPoolForTheGame.length; i++){
            if (quitGame) {
                System.out.println("The current result is: ");
//                showPoints();
                break;
            }
            Question currentQuestion = currentPoolForTheGame[i];
            for(Player player : player){
                System.out.println(player.getName() + " it's your turn!");
                System.out.println(currentQuestion);
                int result = checkAnswer(currentQuestion);
                if(result == 1){
                    int newPoints = player.getPoints()+ currentQuestion.points;
                    player.setPoints(newPoints);
                } else if (result == -1) {
                    System.out.println("The player " +player.getName() +" decided to finish the game");
                    quitGame = true;
                    break;
                }
            }
        }

        showPoints();
        if (!quitGame)
            whoWonTheGame();

    }


    public int checkAnswer(Question question){
        int convertedAnswer = convertAnswer();

        if (question.correctOption == convertedAnswer) {
            System.out.println("Congratulation!!! " + question.answers[question.correctOption] + " is the correct answer!");
            System.out.println("You have just got " + question.points + " points");
            return 1;
        } else if (convertedAnswer == -1) {
            return -1;
        } else{
            System.out.println("Your response was incorrect. Let's try in next round!");
            return 0;
        }

    }
    public int convertAnswer() {

        String answerFromUserInput;
        int answer = -1;
        int counter = 0;
        do {
            if(!keepGoingAskingForChoice(counter))
                break;
            answerFromUserInput = Console.getStringInput("Please provide your answer - A/B/C/D: ").toUpperCase();
            counter++;

            switch (answerFromUserInput) {
                case "A" -> answer = 0;
                case "B" -> answer = 1;
                case "C" -> answer = 2;
                case "D" -> answer = 3;
                case "Q" -> answer = -1;
            }
        } while (!(answerFromUserInput != "A" || answerFromUserInput != "B" || answerFromUserInput != "C" || answerFromUserInput != "D" || answerFromUserInput!= "Q"));
        return answer;
    }

    public boolean keepGoingAskingForChoice(int counter){
        if (counter>2){
            System.out.println("You tried to many times without indicating on any possible option. The game is over");
            return false;
        }
        if(counter>0){
            System.out.println("Your last answer incorrect. Please try once again and decide: A/B/C/D: ");
        }
        return true;
    }

    public void showPoints(){
        for (Player player: player){
            System.out.println("Player " + player.getName() + " has " + player.getPoints() + " points");
        }
    }

    public void whoWonTheGame(){
        Player winner = player[0];
        for (Player player:player){
            if(player.getPoints() > winner.getPoints()){
                winner=player;
            }
        }
        System.out.println(winner.getName() + " won the game wit result of " + winner.getPoints()+ " points");
    }


}
