package quizevaluator.evaluations;

import quizevaluator.*;

public class TotalPointsForParticipantEvaluation implements Evaluation {

    public static int totalPoints(final ResultsByQuizMasterAndParticipant results, final String name) {
        return results.values().stream().mapToInt(map -> map.getOrDefault(name, 0).intValue()).sum();
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(TotalPointsForParticipantEvaluation.totalPoints(results, name));
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
