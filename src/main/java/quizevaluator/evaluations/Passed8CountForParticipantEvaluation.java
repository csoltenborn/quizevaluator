package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed8CountForParticipantEvaluation implements Evaluation {

    public static int passedCount(final ResultsByQuizMasterAndParticipant results, final String name) {
        return results.values().stream().mapToInt(map -> map.getOrDefault(name, 0) >= 8 ? 1 : 0).sum();
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed8CountForParticipantEvaluation.passedCount(results, name));
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
