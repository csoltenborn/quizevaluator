package quizevaluator;

import java.io.*;

public class Main {

    public static void main(final String[] args) throws IOException {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException(
                "You must provide a file with correct answers, a diectory with files containing given answers, and a file for the output!"
            );
        }
        final SolutionsByQuizMaster solutionsByQuiz = Main.parseSolutions(args[0]);
        final AnswersByQuizMasterAndParticipant answersByQuiz = new AnswersByQuizMasterAndParticipant();
        for (final File file : new File(args[1]).listFiles()) {
            try (BufferedReader answersReader = new BufferedReader(new FileReader(file))) {
                answersByQuiz.parseAnswers(answersReader);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]))) {
            new ResultsByQuizMasterAndParticipant(solutionsByQuiz, answersByQuiz).output(writer);
        }
    }

    private static SolutionsByQuizMaster parseSolutions(final String file) throws IOException {
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(file))) {
            return new SolutionsByQuizMaster(solutionReader);
        }
    }

}
