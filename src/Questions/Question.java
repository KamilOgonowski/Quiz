package Questions;

import java.util.Arrays;

public class Question {
    int id;
    String question;
    String[] answers;
    int correctOption;
    int points;
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

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answers=" + Arrays.toString(answers) +
                ", correctOption=" + correctOption +
                ", points=" + points +
                '}';
    }
}
