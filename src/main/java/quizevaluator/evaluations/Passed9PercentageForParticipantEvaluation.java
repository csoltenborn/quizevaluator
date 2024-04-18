package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed9PercentageForParticipantEvaluation implements Evaluation {

    public static double passedPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Evaluation.passedPercentageParticipant(results, name, Passed9CountForParticipantEvaluation::passedCount);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", Passed9PercentageForParticipantEvaluation.passedPercentage(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Gut bestanden Prozent";
    }

}
