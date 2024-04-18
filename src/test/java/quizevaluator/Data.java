package quizevaluator;

public class Data {

    public static final ResultsByQuizMasterAndParticipant RESULTS1 =
        new ResultsByQuizMasterAndParticipant(
            new String[] {"Anna", "Bob", "Claire", "David"},
            new int[][] {
                {-1, 5, 5, 6},
                { 1,-1, 0, 4},
                { 9,10,-1, 8},
                { 9, 9, 4,-1}
            }
        );
    public static final ResultsByQuizMasterAndParticipant RESULTS2 =
        new ResultsByQuizMasterAndParticipant(
            new String[] {"Anna", "Bob", "Claire", "David"},
            new int[][] {
                {-1, 4, 8, 3},
                { 9,-1, 7, 4},
                { 9,10,-1, 0},
                { 9, 9, 8,-1}
            }
        );
    public static final ResultsByQuizMasterAndParticipant RESULTS3 =
        new ResultsByQuizMasterAndParticipant(
            new String[] {"Anna", "Bob", "Claire", "David"},
            new int[][] {
                {-1, 9,10, 9},
                {10,-1,10, 5},
                { 9,10,-1,-1},
                { 7, 9, 8,-1}
            }
        );
    static final String ANSWER1 = "x\ny;1a,3:c, 5) D , 10. B\nz;4a,1A";
    static final String ANSWER2 = "y\nz;4a,3:c, 5) D , 10. B\nx;8d,1A,2a,3a,4b,5b,6b,7b,9d,10c";
    static final String ANSWER3 = "z\ny;1d,3:d, 5) D , 10. d,2d,4d,6d,7d,8d,9d\nx;4a,2d,3d,1d,5d,6d,7d,8d,9d,10d";
    static final String SOLUTIONS = "x;a;b;c;d;a;b;C;D;A;b\ny;A; a;a ; B ; b;b;B;D;D;C\nz;d;d;d;d;d;d;d;d;d;d";

}
