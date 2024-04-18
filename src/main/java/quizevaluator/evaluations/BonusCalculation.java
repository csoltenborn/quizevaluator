package quizevaluator.evaluations;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import quizevaluator.*;

public record BonusCalculation(
    BiFunction<ResultsByQuizMasterAndParticipant, String, Integer> calculation,
    int threshold
) {

    public static int bonus(
        final ResultsByQuizMasterAndParticipant results,
        final String name,
        final BonusCalculation... calculations
    ) {
        return BonusCalculation.bonus(results, name, Arrays.stream(calculations));
    }

    public static int bonus(
        final ResultsByQuizMasterAndParticipant results,
        final String name,
        final Collection<BonusCalculation> calculations
    ) {
        return BonusCalculation.bonus(results, name, calculations.stream());
    }

    public static int bonus(
        final ResultsByQuizMasterAndParticipant results,
        final String name,
        final Stream<BonusCalculation> calculations
    ) {
        return
            calculations
            .mapToInt(c -> c.calculation().apply(results, name) >= c.threshold() ? 1 : 0)
            .sum();
    }

}
