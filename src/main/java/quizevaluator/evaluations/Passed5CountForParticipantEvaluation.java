package quizevaluator.evaluations;

import quizevaluator.*;

public class Passed5CountForParticipantEvaluation implements Evaluation {

    public static int passedCount(final ResultsByQuizMasterAndParticipant results, final String name) {
        return results.values().stream().mapToInt(map -> map.getOrDefault(name, 0) >= 5 ? 1 : 0).sum();
    }

    @Override
    public String cellText(final ResultsByQuizMasterAndParticipant results, final String name) {
        return String.valueOf(Passed5CountForParticipantEvaluation.passedCount(results, name));
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
