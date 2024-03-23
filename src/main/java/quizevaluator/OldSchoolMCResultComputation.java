package quizevaluator;

public class OldSchoolMCResultComputation implements ResultComputation {

    @Override
    public Integer apply(final AnswerData answerData) {
        return Math.max(answerData.correct() - answerData.wrong(), 0);
    }

}
