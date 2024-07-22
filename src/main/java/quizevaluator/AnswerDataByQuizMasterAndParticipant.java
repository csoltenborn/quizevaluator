package quizevaluator;

import java.io.*;
import java.util.*;

public class AnswerDataByQuizMasterAndParticipant extends LinkedHashMap<String, Map<String, AnswerData>> {

    private static final long serialVersionUID = 5684072421495378521L;

    private static int parseNumber(final String answer) {
        return Integer.parseInt(
            answer
            .codePoints()
            .filter(Character::isDigit)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString()
        );
    }

    public AnswerDataByQuizMasterAndParticipant() {
        super();
    }

    public AnswerDataByQuizMasterAndParticipant(final Map<String, Map<String, AnswerData>> map) {
        super(map);
    }

    public void parseAnswers(
        final BufferedReader reader,
        final SolutionsByQuizMaster solutionsByQuizMaster,
        final File file
    ) throws IOException {
        final String quizMaster = reader.readLine().trim();
        final Map<String, AnswerData> answerDataByParticipant = new LinkedHashMap<String, AnswerData>();
        String line = reader.readLine();
        while (line != null) {
            if (line.isBlank()) {
                line = reader.readLine();
                continue;
            }
            final String[] participantAndAnswerText = line.split(";|,");
            if (participantAndAnswerText.length < 2) {
                System.out.println("Warning for file %s: Line does not contain semicolon. Ignoring... Line:\n%s"
                        .formatted(file.getName(), line));
                line = reader.readLine();
                continue;
            }
            final Answer answer = new Answer();
            for (int i = 1; i < participantAndAnswerText.length; i++) {
                final String answerText = participantAndAnswerText[i];
                final Integer value = AnswerParser.INSTANCE.apply(answerText);
                if (value != null) {
                    answer.put(AnswerDataByQuizMasterAndParticipant.parseNumber(answerText), value);
                }
            }
            answerDataByParticipant.put(
                participantAndAnswerText[0],
                answer.toAnswerData(solutionsByQuizMaster.get(quizMaster))
            );
            line = reader.readLine();
        }
        this.put(quizMaster, answerDataByParticipant);
    }

}
