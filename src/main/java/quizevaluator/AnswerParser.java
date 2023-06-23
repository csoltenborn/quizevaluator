package quizevaluator;

import java.util.*;
import java.util.function.*;

public class AnswerParser implements Function<String, Integer>, ToIntFunction<String> {

    public static final AnswerParser INSTANCE = new AnswerParser();

    private AnswerParser() {}

    @Override
    public Integer apply(final String answer) {
        final List<Integer> letters = List.of((int)'A', (int)'B', (int)'C', (int)'D');
        final int[] answerLetter =
            answer.toUpperCase().chars().filter(c -> letters.contains(Integer.valueOf(c))).toArray();
        if (answerLetter == null || answerLetter.length != 1) {
            return null;
        }
        return answerLetter[0] - 'A';
    }

    @Override
    public int applyAsInt(final String answer) {
        return this.apply(answer);
    }

}
