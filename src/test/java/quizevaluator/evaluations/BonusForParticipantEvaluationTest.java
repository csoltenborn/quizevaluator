package quizevaluator.evaluations;

import org.testng.*;
import org.testng.annotations.Test;

import quizevaluator.*;

public class BonusForParticipantEvaluationTest {

    @Test
    public void evaluationTest() {
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Anna"), 2);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Bob"), 0);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS1, "Claire"), 3);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS1, "David"), 1);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Anna"), 1);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Bob"), 1);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS2, "Claire"), 1);
        Assert.assertEquals(new BonusForParticipantEvaluation().evaluation(Data.RESULTS2, "David"), 3);
    }

}
