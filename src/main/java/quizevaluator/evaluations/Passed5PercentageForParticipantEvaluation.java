package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed5PercentageForParticipantEvaluation implements Evaluation {

    public static double passedPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        final double passedTimes100 = Passed5CountForParticipantEvaluation.passedCount(results, name) * 100;
        final int total = (results.size() - 1);
        return passedTimes100 / total;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", Passed5PercentageForParticipantEvaluation.passedPercentage(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Bestanden Prozent";
    }

}
