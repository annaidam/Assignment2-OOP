package assignment2;

public class TypeCalc {
    //we got some help from a classmate to use the matrix before working on task 8
    final static double[][] TYPE_ADVANTAGE = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0.5, 2, 1, 1},
            {1, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 0.5, 0.5, 1, 0.5, 1, 2},
            {1, 2, 0.5, 1, 0.5, 2, 2, 0.5},
            {1, 0.5, 0.5, 1, 0.5, 0.5, 1, 2},
            {1, 1, 2, 1, 0.5, 2, 0.5, 0.5},
            {1, 1, 0.5, 1, 2, 0.5, 1, 0.5}
    };

    public static double getAdvantageMultiplier(int rowIndex, int columnIndex) {
        return TYPE_ADVANTAGE[rowIndex][columnIndex];
    }

    public static String superEffective() {
        String superEffective = " It is super effective!";
        return superEffective;
    }

    public static String notVeryEffective() {
        String notVeryEffective = " It is not very effective...";
        return notVeryEffective;
    }
}
