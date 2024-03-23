package quizevaluator.evaluations;

import quizevaluator.*;

public class PointsPercentageForParticipantEvaluation implements Evaluation {

    public static double pointsPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        final double sumTimes100 = TotalPointsForParticipantEvaluation.totalPoints(results, name) * 100;
        final int total = (results.size() - 1) * 10;
        return sumTimes100 / total;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", PointsPercentageForParticipantEvaluation.pointsPercentage(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Punkte Prozent";
    }

}
