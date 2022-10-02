package assignment2;

public class TypeCalc {
    //for this matrix we got help
    final static double[][] EFFECTIVE_MATRIX = {
            {1, 1, 1, 1},
            {1, 0.5, 0.5, 2},
            {1, 2, 0.5, 0.5},
            {1, 0.5, 2, 0.5}
    };

    /*final static double[][] EFFECTIVE_MATRIX = {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0.5, 2, 1, 1},
            {1, 1, 2, 1, 1, 1, 1, 1},
            {1, 1, 0.5, 0.5, 1, 0.5, 1, 2},
            {1, 2, 0.5, 1, 1, 2, 2, 0.5},
            {1, 0.5, 0.5, 1, 1, 0.5, 1, 2},
            {1, 1, 2, 1, 1, 2, 1, 0.5},
            {1, 1, 0.5, 1, 1, 0.5, 1, 0.5}
    };*/

    public static double getFactorValue(int rowIndex, int columnIndex) {
        return EFFECTIVE_MATRIX[rowIndex][columnIndex];
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
