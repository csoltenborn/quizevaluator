package quizevaluator.evaluations;

import quizevaluator.*;

public class PointsPercentageForQuizMasterEvaluation implements Evaluation {

    public static double pointsPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        final double sumTimes100 = TotalPointsForQuizMasterEvaluation.totalPoints(results, name) * 100;
        final int total = results.get(name).size() * 10;
        return sumTimes100 / total;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", PointsPercentageForQuizMasterEvaluation.pointsPercentage(results, name));
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
