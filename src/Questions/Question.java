package Questions;

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
}
