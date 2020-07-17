package assignment01;

import java.util.Arrays;

/**
 * Implementation of a 2D Mathematical Matrix
 * - includes functionality for multiplying and adding matrices
 *
 * @author MEME DREAM TEAM & Anthony Dirksen
 * @version January 11, 2018
 */
public class Matrix {
    int numRows;
    int numColumns;
    int data[][];

    /**
     * Constructor with data for new matrix (automatically determines dimensions)
     *
     * @param data -- a 2D integer array of data used to initialize the new Matrix object
     */
    public Matrix(int data[][]) {
        numRows = data.length; // d.length is the number of 1D arrays in the 2D array
        if (numRows == 0) {
            numColumns = 0;
        } else {
            numColumns = data[0].length; // d[0] is the first 1D array
        }
        this.data = new int[numRows][numColumns]; // create a new matrix to hold the data
        // copy the data over
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                this.data[i][j] = data[i][j];
            }
        }
    }

    /**
     * Determines whether two objects are equivalent Matrices
     *
     * @param other -- an object to compare to
     * @return -- true if the Matrices are equivalent and false otherwise (or if the second object isn't a Matrix)
     */
    @Override
    // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
    public boolean equals(Object other) {
        if (!(other instanceof Matrix)) { // make sure the Object we're comparing to is a Matrix
            return false;
        }
        Matrix matrix = (Matrix) other; // if the above was not true, we know it's safe to treat 'o' as a Matrix

        return Arrays.deepEquals(this.data, matrix.data);
    }

    /**
     * Converts the Matrix object into a string representation of its data
     *
     * @return -- string representation of the matrix
     */
    @Override
    // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
    public String toString() {

        StringBuilder outputString = new StringBuilder("");

        for(int i = 0; i < numRows; i++)
        {
            for (int j = 0; j < numColumns; j++)
            {
                if (j != numColumns - 1) {
                    outputString.append(data[i][j] + " ");
                }
                else {
                    outputString.append(data[i][j]);
                }
            }
            outputString.append("\n");
        }
        return outputString.toString();
    }

    /**
     * Multiplies two matrix objects resulting in a new product matrix
     *
     * @param matrix -- the right hand side matrix to be multiplied
     * @return -- the resulting matrix of the multiplication
     */
    public Matrix times(Matrix matrix) {
        if (this.numColumns == matrix.numRows) {
            int[][] tempNewMatrix = new int[this.numRows][matrix.data[0].length];
            int columnRightMatrixSpace = 0;

            for (int i = 0; i < this.numRows; i++) {
                for (int j = 0; j < matrix.numColumns; j++) {
                    for (int k = 0; k < this.numColumns; k++) {
                        tempNewMatrix[i][j] += this.data[i][k] * matrix.data[k][j];
                    }
                }
            }
            Matrix newMatrix = new Matrix(tempNewMatrix);
            return newMatrix;

        }
        return null;
    }

    /**
     * Adds two matrix objects together
     *
     * @param matrix -- the right hand side matrix to be added
     * @return -- the resulting matrix of the addition
     */
    public Matrix plus(Matrix matrix) {
        if(this.numRows == matrix.numRows && this.numColumns == matrix.numColumns) {
            int[][] tempNewMatrix = new int[this.numRows][this.numColumns];
            int columnRightMatrixSpace = 0;

            for (int i = 0; i < this.numRows; i++) {
                for (int j = 0; j < this.numColumns; j++) {
                        tempNewMatrix[i][j] += this.data[i][j] + matrix.data[i][j];
                    }
                }
            Matrix newMatrix = new Matrix(tempNewMatrix);
            return newMatrix;

        }
        return null;
    }
}
