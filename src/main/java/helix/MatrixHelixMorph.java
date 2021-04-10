package helix;


public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix(int[][] inMatrix) {

        if (inMatrix == null || inMatrix.length == 0)
            return null;

        int rows = inMatrix.length;

        int cols = 0;

        if (rows > 0) {
            cols = inMatrix[0].length;

            for (int i = 1; i < inMatrix.length; i++) {
                if (cols != inMatrix[i].length) {
                    return null;
                }
            }
        }

        int[][] expOutput = new int[rows][cols];

        int expOutputRowIndex = 0, expOutputColIndex = 0;
        int inMatrixRowIndex = 0, inMatrixColumnIndex = 0;

        while (expOutputRowIndex < rows && expOutputColIndex < cols) {

            for (int i = expOutputColIndex; i < cols; ++i) {
                expOutput[expOutputRowIndex][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }

            expOutputRowIndex++;

            for (int i = expOutputRowIndex; i < rows; ++i) {
                expOutput[i][cols - 1] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                    inMatrixRowIndex++;
                    inMatrixColumnIndex = 0;
                } else {
                    inMatrixColumnIndex++;
                }
            }
            cols--;

            if (expOutputRowIndex < rows) {
                for (int i = cols - 1; i >= expOutputColIndex; --i) {
                    expOutput[rows - 1][i] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                rows--;

            }

            if (expOutputColIndex < cols) {
                for (int i = rows - 1; i >= expOutputRowIndex; --i) {
                    expOutput[i][expOutputColIndex] = inMatrix[inMatrixRowIndex][inMatrixColumnIndex];

                    if (inMatrixColumnIndex == inMatrix[0].length - 1) {
                        inMatrixRowIndex++;
                        inMatrixColumnIndex = 0;
                    } else {
                        inMatrixColumnIndex++;
                    }
                }
                expOutputColIndex++;

            }
        }

        for (int i = 0; i < expOutput.length; i++)
        {
            for (int j = 0; j < expOutput[0].length; j++)
            {
                System.out.print(expOutput[i][j]+ "\t");
            }

            System.out.println();
        }

        return expOutput;
    }
}