package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed9CountForQuizMasterEvaluation implements Evaluation {

    public static int passedCount(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Evaluation.passedCountQuizMaster(results, name, 9);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed9CountForQuizMasterEvaluation.passedCount(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Gut bestanden gesamt";
    }

}
