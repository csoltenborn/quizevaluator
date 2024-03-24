package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed5PercentageForQuizMasterEvaluation implements Evaluation {

    public static double passedPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Evaluation.passedPercentageQuizMaster(results, name, Passed5CountForQuizMasterEvaluation::passedCount);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", Passed5PercentageForQuizMasterEvaluation.passedPercentage(results, name));
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
