package quizevaluator.evaluations;

import org.testng.*;
import org.testng.annotations.Test;

import quizevaluator.*;

public class ModernBonusForQuizMasterEvaluationTest {

    @Test
    public void evaluationTest() {
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS1, "Anna"), 0);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS1, "Bob"), 1);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS1, "Claire"), 0);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS1, "David"), 0);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS2, "Anna"), 3);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS2, "Bob"), 0);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS2, "Claire"), 1);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS2, "David"), 0);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS3, "Anna"), 2);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS3, "Bob"), 3);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS3, "Claire"), 2);
        Assert.assertEquals(new ModernBonusForQuizMasterEvaluation().evaluation(Data.RESULTS3, "David"), 0);
    }

}
