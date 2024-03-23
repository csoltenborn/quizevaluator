package quizevaluator.evaluations;

import quizevaluator.*;

public class BonusForParticipantEvaluation implements Evaluation {

    private static int bonus(final ResultsByQuizMasterAndParticipant results, final String name) {
        int result = 0;
        if (PointsPercentageForParticipantEvaluation.pointsPercentage(results, name) >= 50) {
            result++;
        }
        final int passedPercentage = (int)Passed5PercentageForParticipantEvaluation.passedPercentage(results, name);
        if (passedPercentage == 100) {
            result++;
        }
        if (Passed8PercentageForParticipantEvaluation.passedPercentage(results, name) >= 80) {
            result++;
        }
        return result;
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(BonusForParticipantEvaluation.bonus(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return BonusForParticipantEvaluation.bonus(results, name);
    }

    @Override
    public String title() {
        return "Bonuspunkte";
    }

}
