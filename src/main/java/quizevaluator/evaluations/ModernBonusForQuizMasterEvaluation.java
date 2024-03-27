package quizevaluator.evaluations;

import quizevaluator.*;

public class ModernBonusForQuizMasterEvaluation implements Evaluation {

    private static int bonus(final ResultsByQuizMasterAndParticipant results, final String name) {
        return BonusForQuizMasterEvaluation.bonus(results, name, 80);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(ModernBonusForQuizMasterEvaluation.bonus(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return ModernBonusForQuizMasterEvaluation.bonus(results, name);
    }

    @Override
    public String title() {
        return "Bonus";
    }

}
