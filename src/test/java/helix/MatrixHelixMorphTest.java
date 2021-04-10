package helix;

import org.junit.Test;

import java.rmi.MarshalException;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {



    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x2() {
        int[][] inMatrix = {{1, 2}};
        int[][] expOutput = {{1, 2}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test2x1() {
        int[][] inMatrix = {{1}, {2}};
        int[][] expOutput = {{1}, {2}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testTestMatrix3x3(){
        int[][] inMatrix  = { {1, 2, 3 }, {4, 5, 6}, {7, 8, 9 } };
        int[][] expOutput = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test3x5() {
        int[][] inMatrix = {{1, 2, 3, 4, 5},{ 6, 7, 8, 9, 10},{ 11, 12, 13, 14, 15}};
        int[][] expOutput = {{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x3() {
        int[][] inMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int[][] expOutput = {{1, 2, 3}, {12, 13, 4}, {11, 14, 5}, {10, 15, 6}, {9, 8, 7}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testMatrix4x5(){
        int[][] inMatrix = { { 7, 5, 1, 4, 6 }, { 3, 2, 9, 1, 8 }, { 8, 3, 2, 4, 1 }, { 10, 11, 15, 19, 14 } };
        int[][] expOutput = { { 7, 5, 1, 4, 6 }, { 4, 1, 10, 11, 3 }, { 2, 14, 19, 15, 2 }, { 3, 8, 8, 1, 9 } };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x6() {
        int[][] inMatrix = {{1, 3, 5, 7, 9, 11}, {2, 4, 6, 8, 10, 12}, {13, 15, 17, 19, 21, 23}, {22, 24, 26, 28, 30, 32}};
        int[][] expOutput = {{1, 3, 5, 7, 9, 11}, {19, 21, 23, 22, 24, 2}, {17, 32, 30, 28, 26, 4}, {15, 13, 12, 10, 8, 6}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test6x4() {
        int[][] inMatrix = {{1, 3, 5, 7}, {2, 4, 6, 8}, {9, 11, 13, 15}, {10, 12, 14, 16}, {17, 19, 21, 23}, {18, 20, 22, 24}};
        int[][] expOutput = {{1, 3, 5, 7}, {16, 17, 19, 2}, {14, 24, 21, 4}, {12, 22, 23, 6}, {10, 20, 18, 8}, {15, 13, 11, 9}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testMatrix0x0(){
        int[][] inMatrix = {};
        int[][] expOutput = {};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public  void nullMatrixTest(){
        int[][] inMatrix = null;
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void invalidMatrixTest() {
        int[][] inMatrix = {{1, 2}, {3, 4, 5}, {6, 7}};
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
    // ADD TESTS TO CHECK PARTITIONS
}
