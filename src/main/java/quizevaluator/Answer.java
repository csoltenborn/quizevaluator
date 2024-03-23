package quizevaluator;

import java.util.*;

public class Answer extends LinkedHashMap<Integer, Integer> {

    private static final long serialVersionUID = 6300499350326077871L;

    public AnswerData toAnswerData(final Answer correctAnswer) {
        final int total = correctAnswer.size();
        int correct = 0;
        int wrong = 0;
        for (final Map.Entry<Integer, Integer> entry : this.entrySet()) {
            final Integer question = entry.getKey();
            if (!correctAnswer.containsKey(question)) {
                throw new IllegalStateException("Found choice for a question which is not part of the correct answer!");
            }
            final Integer choice = entry.getValue();
            if (correctAnswer.get(question).equals(choice)) {
                correct++;
            } else {
                wrong++;
            }
        }
        return new AnswerData(total, correct, wrong);
    }

}
