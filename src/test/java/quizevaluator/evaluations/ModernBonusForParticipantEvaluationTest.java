package quizevaluator.evaluations;

import org.testng.*;
import org.testng.annotations.Test;

import quizevaluator.*;

public class ModernBonusForParticipantEvaluationTest {

    @Test
    public void evaluationTest() {
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Anna"), 0);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Bob"), 0);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Claire"), 2);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS1, "David"), 1);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Anna"), 0);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Bob"), 1);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Claire"), 1);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS2, "David"), 2);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS3, "Anna"), 3);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS3, "Bob"), 1);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS3, "Claire"), 1);
        Assert.assertEquals(new ModernBonusForParticipantEvaluation().evaluation(Data.RESULTS3, "David"), 2);
    }

}
