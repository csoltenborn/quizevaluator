package quizevaluator.evaluations;

import quizevaluator.*;

public class BonusForQuizMasterEvaluation implements Evaluation {

    private static int bonus(final ResultsByQuizMasterAndParticipant results, final String name) {
        int result = 0;
        if (PointsPercentageForQuizMasterEvaluation.pointsPercentage(results, name) >= 75) {
            result++;
        }
        final int passedPercentage = (int)Passed5PercentageForQuizMasterEvaluation.passedPercentage(results, name);
        if (passedPercentage == 100) {
            result++;
        }
        if (Passed8PercentageForQuizMasterEvaluation.passedPercentage(results, name) >= 80) {
            result++;
        }
        return result;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(BonusForQuizMasterEvaluation.bonus(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return BonusForQuizMasterEvaluation.bonus(results, name);
    }

    @Override
    public String title() {
        return "Bonus";
    }

}
