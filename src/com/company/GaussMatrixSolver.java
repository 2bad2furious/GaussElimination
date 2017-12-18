package com.company;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.rmi.CORBA.Util;
import java.util.Arrays;
import java.util.Optional;

public class GaussMatrixSolver {
    private Integer[][] matrix;

    public GaussMatrixSolver(Integer[][] matrix) throws IllegalArgumentException {
        this.matrix = matrix;

        verify();
    }

    private void verify() throws IllegalArgumentException {
        int n;
        if (matrix == null || (n = this.matrix.length) == 0)
            throw new IllegalArgumentException("Invalid matrix - array empty");

        for (Integer[] row : this.matrix) {
            if (row.length != n + 1) throw new IllegalArgumentException("Invalid matrix - array not n*(n+1)");
        }
    }

    //TODO find unsolvable ones
    public Optional<Fraction[]> solve() {
        /*
        the matrix looks like
        A  B  C  D
        E  F  G  H
        I  J  K  L
         */
        for (int height = 0; height < matrix.length; height++) {
            for (int i = height + 1; i < matrix.length; i++) {
                //get 0 in i-row[height] index
                try {
                    //pretty hard to check it here
                    matrix[i] = Utils.subtractForZero(matrix[i], matrix[height], height);
                }catch (ArithmeticException e){
                    return Optional.empty();
                }
            }
        }
        /*
        the matrix looks like this
         A  B  C  D
         0  M  N  O
         0  0  P  Q
         */
        for (int height = matrix.length - 2; height >= 0; height--) {
            for (int i = matrix[height].length - 2; i > height; i--) {
                Integer val = matrix[height][i];
                if (val != 0) {
                    Integer[] subrahend = matrix[height + 1];
                    if (subrahend[i] == 0) subrahend = matrix[i];
                    matrix[height] = Utils.subtractForZero(matrix[height], subrahend, i);
                }
            }
        }
        /*
        the matrix looks like
        A  0  0  D
        0  M  0  O
        0  0  P  Q
         */
        Fraction[] results = new Fraction[matrix.length];
        //beautify
        for (int height = 0; height < matrix.length; height++) {
            matrix[height] = Utils.beautifyArray(matrix[height]);
            results[height] = new Fraction(matrix[height][matrix[height].length-1], matrix[height][height]);
        }
        return Optional.of(results);
    }
}