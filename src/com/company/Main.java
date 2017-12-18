package com.company;

import java.util.Arrays;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        Integer[][] matrix = {
                {1, 3, 1, 9},
                {1, -1, 1, 1},
                {3, 11, 5, 35}
        };

        GaussMatrixSolver g = new GaussMatrixSolver(matrix);
        Utils.print(matrix);
        Optional<Fraction[]> o = g.solve();

        System.out.println(o.map(fractions -> "Result is:\n" + Arrays.toString(fractions)).orElse("No result"));
    }
}
