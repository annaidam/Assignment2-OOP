package assignment2;

// TODO: comment this static Class
public class TypeCalc {
    final static double[][] EFFECTIVE_MATRIX = {
            {1, 1, 1, 1},
            {1, 0.5, 0.5, 2},
            {1, 2, 0.5, 0.5},
            {1, 0.5, 2, 0.5}
    };

    public static double getFactorValue(int rowIndex, int columnIndex) {
        return EFFECTIVE_MATRIX[rowIndex][columnIndex];
    }
}
