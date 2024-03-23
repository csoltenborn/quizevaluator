package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed8PercentageForParticipantEvaluation implements Evaluation {

    public static double passedPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        final double passedTimes100 = Passed8CountForParticipantEvaluation.passedCount(results, name) * 100;
        final int total = (results.size() - 1);
        return passedTimes100 / total;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", Passed8PercentageForParticipantEvaluation.passedPercentage(results, name));
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
