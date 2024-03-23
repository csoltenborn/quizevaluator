package quizevaluator;

import java.io.*;
import java.util.*;

import quizevaluator.evaluations.*;

public class Main {

    static final List<Evaluation> PARTICIPANTS_EVALUATIONS =
        List.of(
            new TotalPointsForParticipantEvaluation(),
            new PointsPercentageForParticipantEvaluation(),
            new Passed5CountForParticipantEvaluation(),
            new Passed5PercentageForParticipantEvaluation(),
            new Passed8CountForParticipantEvaluation(),
            new Passed8PercentageForParticipantEvaluation(),
            new BonusForParticipantEvaluation()
        );

    static final List<Evaluation> QUIZ_MASTER_EVALUATIONS =
        List.of(
            new TotalPointsForQuizMasterEvaluation(),
            new PointsPercentageForQuizMasterEvaluation(),
            new Passed5CountForQuizMasterEvaluation(),
            new Passed5PercentageForQuizMasterEvaluation(),
            new Passed5TotalForQuizMasterEvaluation(),
            new Passed8CountForQuizMasterEvaluation(),
            new Passed8PercentageForQuizMasterEvaluation(),
            new BonusForQuizMasterEvaluation()
        );

    public static void main(final String[] args) throws IOException {
        if (args == null || args.length != 3) {
            throw new IllegalArgumentException(
                "You must provide a file with correct answers, a diectory with files containing given answers, and a file for the output!"
            );
        }
        final SolutionsByQuizMaster solutionsByQuizMaster = Main.parseSolutions(args[0]);
        final AnswerDataByQuizMasterAndParticipant answerDataByQuizMasterAndParticipant =
            new AnswerDataByQuizMasterAndParticipant();
        for (final File file : new File(args[1]).listFiles()) {
            try (BufferedReader answersReader = new BufferedReader(new FileReader(file))) {
                answerDataByQuizMasterAndParticipant.parseAnswers(answersReader, solutionsByQuizMaster);
            }
        }
        final ResultsByQuizMasterAndParticipant results =
            new ResultsByQuizMasterAndParticipant(
                answerDataByQuizMasterAndParticipant,
                new OldSchoolMCResultComputation()
            );
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]))) {
            new CSVWriter(writer).writeCSV(results, Main.QUIZ_MASTER_EVALUATIONS, Main.PARTICIPANTS_EVALUATIONS);
        }
    }

    private static SolutionsByQuizMaster parseSolutions(final String file) throws IOException {
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(file))) {
            return new SolutionsByQuizMaster(solutionReader);
        }
    }

}
