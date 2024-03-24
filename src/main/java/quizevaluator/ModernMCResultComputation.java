package quizevaluator;

public class ModernMCResultComputation implements ResultComputation {

    @Override
    public Integer apply(final AnswerData answerData) {
        return answerData.correct();
    }

}
