package Questions;

import ConsoleInput.Console;

import java.util.Random;

public class PoolOfQuestions implements GeneratePoolOfQuestion{
    int lengthOfList;
    public static Random generateRadnom = new Random();
    Question [] poolOfQuestionForTheGame;



    Question [] listOfQuestions = {new Question(1,"Which class you can use to create mutable String objects?: ",
            new String[]{"Mutable class","String class", "String class", "StringBuilder class"},
            3,2),

            new Question(2,"What does the JVM stands for? ",
                    new String[]{"Java Vertical Multiplication","Java Virtual Machine", "Java Virtual Messages", "Join Virtual Machine"},
                    1,2),

            new Question(3,"What is a 'compiler' in Java?",
                    new String[]{"A program that translates Java source code into bytecode",
                            "A program that runs Java applications", "A Java keyword", "A data type"},
                    0,2),

            new Question(4,"What is the 'this' keyword used for in Java?",
                    new String[]{"To create a new instance of a class","To specify the visibility of a method",
                            "To refer to the current instance of the class", "To start a new thread"},
                    2,2),

            new Question(5,"What is the main difference between an abstract class and an interface in Java",
                    new String[]{"An abstract class can have concrete methods, while an interface cannot","An abstract class cannot have any methods, while an interface can",
                            "An abstract class is a keyword in Java, while an interface is not", "An abstract class and an interface are the same thing in Java"},
                    0,2),

            new Question(6, "Which of the following access modifiers allows a class to be accessed from anywhere?",
                    new String[]{"public", "private", "protected", "default"},
                    0, 2),

            new Question(7, "What is the purpose of the 'super' keyword in Java?",
                    new String[]{"To create a new object", "To access the superclass of a class",
                            "To specify the visibility of a method", "To define a loop"},
                    1, 2),

            new Question(8, "What is the result of 7 % 3 in Java?",
                    new String[]{"3", "2", "1", "0"},
                    2, 2),


            new Question(9, "Which data structure in Java uses a 'Last-In, First-Out' (LIFO) approach?",
                    new String[]{"Queue", "ArrayList", "LinkedHashMap", "Stack"},
                    3, 2),

            new Question(10, "What is the Java keyword used to indicate that a method does not return a value?",
                    new String[]{"void", "null", "public", "static"},
                    0, 2)

    };

    public Question [] generateUniqePool(){
        lengthOfList = listOfQuestions.length;
        int numberOfQuestionsToBeGenerated = Console.getIntInput("How many questions would you like to generate?\n Maximum amount is " + lengthOfList);
        poolOfQuestionForTheGame = generateListWithDefaultValues(numberOfQuestionsToBeGenerated);
        for(int i = 0; i<numberOfQuestionsToBeGenerated; i++){
            while(true){
                int indexOfGeneratedQuestion = generateRadnom.nextInt(1, lengthOfList+1);
                if(checkIfUnique(indexOfGeneratedQuestion)){
                    poolOfQuestionForTheGame[i] = listOfQuestions[indexOfGeneratedQuestion-1];
                    break;

                } else continue;
            }
        }
        return poolOfQuestionForTheGame;
    }

    public boolean checkIfUnique(int indexOfGeneratedQuestion){
        for (Question question: poolOfQuestionForTheGame){
            if (question.id == indexOfGeneratedQuestion){
                return false;
            }
        }
        return true;
    }

    public Question [] generateListWithDefaultValues(int numberOfQuestionsToBeGenerated){
        poolOfQuestionForTheGame = new Question[numberOfQuestionsToBeGenerated];
        for(int i = 0; i<numberOfQuestionsToBeGenerated; i++){
            poolOfQuestionForTheGame[i] = new Question();
        }
        return poolOfQuestionForTheGame;
    }
}
