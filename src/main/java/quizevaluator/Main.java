package quizevaluator;

import java.io.*;
import java.util.*;

import quizevaluator.evaluations.*;

public class Main {

    static final List<Evaluation> PARTICIPANTS_EVALUATIONS_NEW =
        List.of(
            new TotalPointsForParticipantEvaluation(),
            new PointsPercentageForParticipantEvaluation(),
            new Passed6CountForParticipantEvaluation(),
            new Passed6PercentageForParticipantEvaluation(),
            new Passed8CountForParticipantEvaluation(),
            new Passed8PercentageForParticipantEvaluation(),
            new BonusForParticipantEvaluation()
        );

    static final List<Evaluation> PARTICIPANTS_EVALUATIONS_OLD =
        List.of(
            new TotalPointsForParticipantEvaluation(),
            new PointsPercentageForParticipantEvaluation(),
            new Passed5CountForParticipantEvaluation(),
            new Passed5PercentageForParticipantEvaluation(),
            new Passed8CountForParticipantEvaluation(),
            new Passed8PercentageForParticipantEvaluation(),
            new BonusForParticipantEvaluation()
        );

    static final List<Evaluation> QUIZ_MASTER_EVALUATIONS_NEW =
        List.of(
            new TotalPointsForQuizMasterEvaluation(),
            new PointsPercentageForQuizMasterEvaluation(),
            new Passed6CountForQuizMasterEvaluation(),
            new Passed6PercentageForQuizMasterEvaluation(),
            new Passed6TotalForQuizMasterEvaluation(),
            new Passed8CountForQuizMasterEvaluation(),
            new Passed8PercentageForQuizMasterEvaluation(),
            new ModernBonusForQuizMasterEvaluation()
        );

    static final List<Evaluation> QUIZ_MASTER_EVALUATIONS_OLD =
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
        if (args == null || args.length < 3 || args.length > 4) {
            throw new IllegalArgumentException(
                "You must provide a file with correct answers, a diectory with files containing given answers, and a "
                + "file for the output!\nYou may additionally specify an evaluation mode (old/new)."
            );
        }
        final FormsExcelToCsvConverter excelConverter = new FormsExcelToCsvConverter();
        final SolutionsByQuizMaster solutionsByQuizMaster = Main.parseSolutions(args[0]);
        final AnswerDataByQuizMasterAndParticipant answerDataByQuizMasterAndParticipant =
            new AnswerDataByQuizMasterAndParticipant();
        boolean thereWereErrors = false;
        for (File file : new File(args[1]).listFiles()) {
            try {
                if (excelConverter.isExcelFile(file)) {
                    file = excelConverter.convert(file);
                }
                try (BufferedReader answersReader = new BufferedReader(new FileReader(file))) {
                    answerDataByQuizMasterAndParticipant.parseAnswers(answersReader, solutionsByQuizMaster, file);
                }
            } catch (Exception e) {
                thereWereErrors = true;
                System.err.println("File %s: %s".formatted(file.getName(), e.getMessage()));
            }
        }
        if (thereWereErrors) {
            System.err.println("\nErrors while parsing answers - please fix them. Exiting...");
            System.exit(1);
        }

        plausibilityCheck(solutionsByQuizMaster, answerDataByQuizMasterAndParticipant);

        final boolean newMode = args.length == 4 ? args[3].toLowerCase().equals("new") : false;
        final ResultsByQuizMasterAndParticipant results =
            new ResultsByQuizMasterAndParticipant(
                answerDataByQuizMasterAndParticipant,
                newMode ? new ModernMCResultComputation() : new OldSchoolMCResultComputation()
            );
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[2]))) {
            new CSVWriter(writer).writeCSV(
                results,
                newMode ? Main.QUIZ_MASTER_EVALUATIONS_NEW : Main.QUIZ_MASTER_EVALUATIONS_OLD,
                newMode ? Main.PARTICIPANTS_EVALUATIONS_NEW : Main.PARTICIPANTS_EVALUATIONS_OLD
            );
        } catch (Exception e) {
            System.err.println("Error while computing and writing results: %s".formatted(e.getMessage()));
            System.exit(1);
        }
    }

    private static void plausibilityCheck(SolutionsByQuizMaster solutionsByQuizMaster, AnswerDataByQuizMasterAndParticipant answerDataByQuizMasterAndParticipant) {
        System.out.println("Plausibility Check");
        System.out.println("==================");

        var allParticipants = new HashSet<String>();
        for (var answers : answerDataByQuizMasterAndParticipant.values()) {
            allParticipants.addAll(answers.keySet());
        }

        var quizmastersNotInParticipants = new HashSet<>(solutionsByQuizMaster.keySet());
        quizmastersNotInParticipants.removeAll(allParticipants);

        var participantsNotInQuizmasters = new HashSet<>(allParticipants);
        participantsNotInQuizmasters.removeAll(solutionsByQuizMaster.keySet());

        if (quizmastersNotInParticipants.isEmpty() && participantsNotInQuizmasters.isEmpty()) {
            System.out.println("No problems found.");
        } else {
            System.out.println("Quizmasters not in participants: " + quizmastersNotInParticipants);
            System.out.println("Participants not in quizmasters: " + participantsNotInQuizmasters);
        }
    }

    private static SolutionsByQuizMaster parseSolutions(final String file) throws IOException {
        try (BufferedReader solutionReader = new BufferedReader(new FileReader(file))) {
            return new SolutionsByQuizMaster(solutionReader);
        }
    }

}
