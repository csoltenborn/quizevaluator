package quizevaluator.evaluations;

import quizevaluator.*;

public interface Evaluation {

    String cellText(ResultsByQuizMasterAndParticipant results, String name);

    Integer evaluation(ResultsByQuizMasterAndParticipant results, String name);

    String title();

}
