package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed5CountForQuizMasterEvaluation implements Evaluation {

    public static int passedCount(final ResultsByQuizMasterAndParticipant results, final String name) {
        return results.get(name).values().stream().mapToInt(points -> points >= 5 ? 1 : 0).sum();
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed5CountForQuizMasterEvaluation.passedCount(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Bestanden gesamt";
    }

}
