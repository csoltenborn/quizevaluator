package quizevaluator.evaluations;

import quizevaluator.*;

public class TotalPointsForQuizMasterEvaluation implements Evaluation {

    public static int totalPoints(final ResultsByQuizMasterAndParticipant results, final String name) {
        return results.get(name).values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(TotalPointsForQuizMasterEvaluation.totalPoints(results, name));
    }

    @Override
    public Integer evaluation(final ResultsByQuizMasterAndParticipant results, final String name) {
        return 0;
    }

    @Override
    public String title() {
        return "Punkte gesamt";
    }

}
