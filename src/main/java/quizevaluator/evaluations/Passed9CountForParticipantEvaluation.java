package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed9CountForParticipantEvaluation implements Evaluation {

    public static int passedCount(final ResultsByQuizMasterAndParticipant results, final String name) {
        return Evaluation.passedCountParticipant(results, name, 9);
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed9CountForParticipantEvaluation.passedCount(results, name));
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
