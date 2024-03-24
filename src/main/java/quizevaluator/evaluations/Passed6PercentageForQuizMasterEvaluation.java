package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed6PercentageForQuizMasterEvaluation implements Evaluation {

    public static double passedPercentage(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Evaluation.passedPercentageQuizMaster(results, name, Passed6CountForQuizMasterEvaluation::passedCount);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.format("%.2f", Passed6PercentageForQuizMasterEvaluation.passedPercentage(results, name));
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
