package quizevaluator.evaluations;

import quizevaluator.*;

public class BonusForQuizMasterEvaluation implements Evaluation {

    public static int bonus(final ResultsByQuizMasterAndParticipant results, final String name, int pointsPercentage) {
        int result = 0;
        if (PointsPercentageForQuizMasterEvaluation.pointsPercentage(results, name) >= pointsPercentage) {
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

    private static int bonus(final ResultsByQuizMasterAndParticipant results, final String name) {
        return bonus(results, name, 75);
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
