package Questions;

import java.util.Arrays;

public class Question {
    int id;
    String question;
    public String[] answers;
    public int correctOption;
    public int points;
//    public Question(int id, String question, String[] answers, int correctOption, int points) {
//    }

    public Question(int id, String question, String[] answers, int correctOption, int points) {
        this.id = id;
        this.question = question;
        this.answers = answers;
        this.correctOption = correctOption;
        this.points = points;
    }

    public Question(){
        this.id = 0;
    }

//    @Override
//    public String toString() {
//        String asd ="Question{" +
//                "id=" + id +
//                ", question='" + question + '\'' +
//                ", answers=" + Arrays.toString(answers) +
//                ", answers=" + "\n" + showAnswers() +
//                ", correctOption=" + correctOption +
//                ", points=" + points +
//                '}';
//        return asd;
//    }


    @Override
    public String toString() {
        return
                "\n" + question + ":\n" +
                showAnswers() +
                "\n Temporary information " + "id=" + id +
                ", correctOption=" + correctOption +
                ", points=" + points +
                '}';
//        return asd;
    }

//    public String prepareAnswersDisplay(Question question){
//        for (Array [] : question){
//
//        }
//    }

    public StringBuilder showAnswers(){
        StringBuilder possibleAnswers = new StringBuilder();
        String [] responseIndicator = {"A. ", "B. ", "C. ", "D. "};
        for (int i =0; i<answers.length; i++){
            possibleAnswers.append("\n\t").append(responseIndicator[i]).append(" ").append(answers[i]);
        }
        return possibleAnswers;


//            switch(i){
//                case 0 -> responseIndicator[i] + answers[i];
//            }
//            case i=0{
//
//            }



//        for(String odp: answers){
//            System.out.println(odp);
//        }
    }
}
