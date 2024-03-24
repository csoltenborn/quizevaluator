package quizevaluator.evaluations;

import java.util.function.*;

import quizevaluator.*;

public interface Evaluation {

    public static int passedCountParticipant(
        final ResultsByQuizMasterAndParticipant results,
        final String participant,
        final int passLimit
    ) {
        return results.values().stream().mapToInt(map -> map.getOrDefault(participant, 0) >= passLimit ? 1 : 0).sum();
    }

    public static int passedCountQuizMaster(
        final ResultsByQuizMasterAndParticipant results,
        final String quizMaster,
        final int passLimit
    ) {
        return results.get(quizMaster).values().stream().mapToInt(points -> points >= passLimit ? 1 : 0).sum();
    }

    public static double passedPercentage(
        final ResultsByQuizMasterAndParticipant results,
        final String name,
        final BiFunction<ResultsByQuizMasterAndParticipant, String, Integer> countFunction
    ) {
        final double passedTimes100 = countFunction.apply(results, name) * 100;
        final int total = (results.size() - 1);
        return passedTimes100 / total;
    }

    String cellText(ResultsByQuizMasterAndParticipant results, String name);

    Integer evaluation(ResultsByQuizMasterAndParticipant results, String name);

    String title();

}
