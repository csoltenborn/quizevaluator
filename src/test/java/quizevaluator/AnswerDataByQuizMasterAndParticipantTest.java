package quizevaluator;

import java.io.*;
import java.util.*;

import org.testng.*;
import org.testng.Assert.*;
import org.testng.annotations.Test;

class AnswerDataByQuizMasterAndParticipantTest {

    @Test
    void parseAnswersTest() throws IOException {
        final AnswerDataByQuizMasterAndParticipant answers = new AnswerDataByQuizMasterAndParticipant();
        final Map<String, Answer> solutions = new LinkedHashMap<String, Answer>();
        final Answer solution1 = new Answer();
        solution1.put(1, 0);
        solution1.put(2, 1);
        solution1.put(3, 2);
        solution1.put(4, 3);
        solution1.put(5, 0);
        solution1.put(6, 1);
        solution1.put(7, 2);
        solution1.put(8, 3);
        solution1.put(9, 0);
        solution1.put(10, 1);
        final Answer solution2 = new Answer();
        solution2.put(1, 0);
        solution2.put(2, 0);
        solution2.put(3, 0);
        solution2.put(4, 1);
        solution2.put(5, 1);
        solution2.put(6, 1);
        solution2.put(7, 1);
        solution2.put(8, 3);
        solution2.put(9, 3);
        solution2.put(10, 2);
        final Answer solution3 = new Answer();
        solution3.put(1, 3);
        solution3.put(2, 3);
        solution3.put(3, 3);
        solution3.put(4, 3);
        solution3.put(5, 3);
        solution3.put(6, 3);
        solution3.put(7, 3);
        solution3.put(8, 3);
        solution3.put(9, 3);
        solution3.put(10, 3);
        solutions.put("x", solution1);
        solutions.put("y", solution2);
        solutions.put("z", solution3);
        final SolutionsByQuizMaster solutionsByQuizMaster = new SolutionsByQuizMaster(solutions);
        try (BufferedReader reader = new BufferedReader(new StringReader(Data.ANSWER1))) {
            answers.parseAnswers(reader, solutionsByQuizMaster, new File("DUMMY"));
        }
        Assert.assertEquals(answers.size(), 1);
        Assert.assertTrue(answers.containsKey("x"));
        final Map<String, AnswerData> answersForX = answers.get("x");
        Assert.assertEquals(answersForX.size(), 2);
        Assert.assertTrue(answersForX.containsKey("y"));
        Assert.assertTrue(answersForX.containsKey("z"));
        final AnswerData answersForXFromZ = answersForX.get("z");
        Assert.assertEquals(answersForXFromZ.total(), 10);
        Assert.assertEquals(answersForXFromZ.correct(), 1);
        Assert.assertEquals(answersForXFromZ.wrong(), 1);
        final AnswerData answersForXFromY = answersForX.get("y");
        Assert.assertEquals(answersForXFromY.total(), 10);
        Assert.assertEquals(answersForXFromY.correct(), 3);
        Assert.assertEquals(answersForXFromY.wrong(), 1);
        try (BufferedReader reader = new BufferedReader(new StringReader(Data.ANSWER2))) {
            answers.parseAnswers(reader, solutionsByQuizMaster, new File("DUMMY"));
        }
        Assert.assertEquals(answers.size(), 2);
        Assert.assertTrue(answers.containsKey("x"));
        Assert.assertTrue(answers.containsKey("y"));
        Assert.assertEquals(answers.get("x").get("y").correct(), 3);
        Assert.assertEquals(answers.get("x").get("y").wrong(), 1);
        Assert.assertEquals(answers.get("y").get("z").correct(), 0);
        Assert.assertEquals(answers.get("y").get("z").wrong(), 4);
    }

    @Test
    void parseEmptyAnswersTest() throws IOException {
        final AnswerDataByQuizMasterAndParticipant answers = new AnswerDataByQuizMasterAndParticipant();
        try (BufferedReader reader = new BufferedReader(new StringReader(""))) {
            Assert.assertThrows(new ThrowingRunnable () {

                @Override
                public void run() throws IOException {
                    answers.parseAnswers(reader, new SolutionsByQuizMaster(Collections.emptyMap()), new File("DUMMY"));
                }

            });
        }
    }

}
