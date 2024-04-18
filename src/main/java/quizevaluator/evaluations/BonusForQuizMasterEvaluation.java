package quizevaluator.evaluations;

import quizevaluator.*;

public class BonusForQuizMasterEvaluation implements Evaluation {

    private static final BonusCalculation[] CALCULATIONS =
        new BonusCalculation[] {
            new BonusCalculation(
                (results, name) -> (int)PointsPercentageForQuizMasterEvaluation.pointsPercentage(results, name),
                75
            ),
            new BonusCalculation(
                (results, name) -> (int)Passed5PercentageForQuizMasterEvaluation.passedPercentage(results, name),
                100
            ),
            new BonusCalculation(
                (results, name) -> (int)Passed8PercentageForQuizMasterEvaluation.passedPercentage(results, name),
                80
            )
        };

    private static int bonus(final ResultsByQuizMasterAndParticipant results, final String name) {
        return BonusCalculation.bonus(results, name, BonusForQuizMasterEvaluation.CALCULATIONS);
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
