package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed6TotalForQuizMasterEvaluation implements Evaluation {

    private static int passedTotal(final ResultsByQuizMasterAndParticipant results, final String name) {
        if (Passed6CountForQuizMasterEvaluation.passedCount(results, name) == 0) {
            return 0;
        }
        final int passedPercentage = (int)Passed6PercentageForQuizMasterEvaluation.passedPercentage(results, name);
        return Math.min(10, (passedPercentage / 10) + 1);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed6TotalForQuizMasterEvaluation.passedTotal(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Passed6TotalForQuizMasterEvaluation.passedTotal(results, name);
    }

    @Override
    public String title() {
        return "Bestanden Bewertung";
    }

}
