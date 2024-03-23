package quizevaluator;

import java.util.*;

public class ResultsByQuizMasterAndParticipant extends LinkedHashMap<String, Map<String, Integer>> {

    private static final long serialVersionUID = -3759177469532639760L;

    public ResultsByQuizMasterAndParticipant(
        final AnswerDataByQuizMasterAndParticipant answersByQuizMasterAndParticipant,
        final ResultComputation resultComputation
    ) {
        for (final String quizMaster : answersByQuizMasterAndParticipant.keySet()) {
            final Map<String, Integer> resultsByParticipant = new LinkedHashMap<String, Integer>();
            final Map<String, AnswerData> answersByParticipant =
                answersByQuizMasterAndParticipant.get(quizMaster);
            for (final String participant : answersByParticipant.keySet()) {
                resultsByParticipant.put(participant, resultComputation.apply(answersByParticipant.get(participant)));
            }
            this.put(quizMaster, resultsByParticipant);
        }
    }

}
