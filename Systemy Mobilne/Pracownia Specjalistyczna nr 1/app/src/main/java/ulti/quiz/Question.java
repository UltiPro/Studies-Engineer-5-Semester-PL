package ulti.quiz;

public class Question {
    private int questionId;
    private boolean trueAnswer;

    public Question(int questionId, boolean answer) {
        this.questionId = questionId;
        this.trueAnswer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswer(boolean answer) {
        this.trueAnswer = answer;
    }
}