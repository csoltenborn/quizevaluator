package quizevaluator;

import java.io.IOException;
import java.util.*;

public class ResultsByQuizMasterAndParticipant extends LinkedHashMap<String, Map<String, Integer>> {

    private static final long serialVersionUID = -3759177469532639760L;

    public ResultsByQuizMasterAndParticipant(
        final AnswerDataByQuizMasterAndParticipant answersByQuizMasterAndParticipant,
        final ResultComputation resultComputation
    ) throws IOException {
        for (final String quizMaster : answersByQuizMasterAndParticipant.keySet()) {
            final Map<String, Integer> resultsByParticipant = new LinkedHashMap<String, Integer>();
            final Map<String, AnswerData> answersByParticipant =
                answersByQuizMasterAndParticipant.get(quizMaster);
            if (answersByParticipant == null) {
                throw new IOException("No solution found for quizmaster '%s'".formatted(quizMaster));
            }
            for (final String participant : answersByParticipant.keySet()) {
                resultsByParticipant.put(participant, resultComputation.apply(answersByParticipant.get(participant)));
            }
            this.put(quizMaster, resultsByParticipant);
        }
    }

    ResultsByQuizMasterAndParticipant(final String[] names, final int[][] results) {
        for (int quizMaster = 0; quizMaster < names.length; quizMaster++) {
            final Map<String, Integer> resultsByParticipant = new LinkedHashMap<String, Integer>();
            for (int participant = 0; participant < names.length; participant++) {
                final int result = results[participant][quizMaster];
                if (result >= 0) {
                    resultsByParticipant.put(names[participant], result);
                }
            }
            this.put(names[quizMaster], resultsByParticipant);
        }
    }

}
