package com.company;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Utils {

    /**
     * https://stackoverflow.com/a/4009247
     *
     * @param x
     * @param y
     * @return biggestCommonDivisor
     */
    public static Integer greatestCommonDivisor(Integer x, Integer y) {
        if (y == 0) return x;
        return greatestCommonDivisor(y, x % y);
    }

    /**
     * https://www.programiz.com/java-programming/examples/lcm EXAMPLE 2
     *
     * @param x
     * @param y
     * @return least
     */
    public static Integer leastCommonMultiple(Integer x, Integer y) {
        return x * y / greatestCommonDivisor(x, y);
    }

    public static Integer greatestCommonDivisor(Integer[] integers) {
        if (integers.length == 0) return 1; //or throw exception?
        if (integers.length == 1) return integers[0];
        if (integers.length == 2) return greatestCommonDivisor(integers[0], integers[1]);

        //TODO beaturify
        Integer[] newIntegers = new Integer[integers.length - 1];
        for (int i = 0; i < integers.length - 1; i++) {
            if (i == integers.length - 2) newIntegers[i] = greatestCommonDivisor(integers[i], integers[i + 1]);
            else newIntegers[i] = integers[i];
        }
        return greatestCommonDivisor(newIntegers);
    }

    public static Integer[] beautifyArray(Integer[] integers) {
        Integer gcd = greatestCommonDivisor(integers);
        if (gcd == 1) return integers;

        Integer[] newIntegers = new Integer[integers.length];
        for (int i = 0; i < newIntegers.length; i++) {
            newIntegers[i] = integers[i] / gcd;
        }
        return newIntegers;
    }

    /**
     * https://en.wikipedia.org/wiki/Subtraction
     *
     * @param minuhends
     * @param subtrahends
     * @return Integer[] of differences
     */
    public static Integer[] subtractArrays(Integer[] minuhends, Integer[] subtrahends) {
        if (minuhends.length != subtrahends.length) throw new IllegalArgumentException("Arrays must have same length");
        Integer[] differences = new Integer[minuhends.length];
        for (int i = 0; i < differences.length; i++) {
            differences[i] = minuhends[i] - subtrahends[i];
        }
        return differences;
    }

    public static Integer[] multipleArray(Integer[] arr, Integer multiplier) {
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i] * multiplier;
        }
        return newArr;
    }

    /**
     * @param minuhend
     * @param subtrahend
     * @param index for the 0
     * @return
     */
    public static Integer[] subtractForZero(Integer[] minuhend,Integer[] subtrahend,int index){
        int lcm = Utils.leastCommonMultiple(subtrahend[index], minuhend[index]);
        Integer[] real_minuhend = Utils.multipleArray(minuhend, lcm / minuhend[index]);
        Integer[] real_subtrahend = Utils.multipleArray(subtrahend, lcm / subtrahend[index]);
        return Utils.subtractArrays(real_minuhend, real_subtrahend);
    }

    /**
     * Dont even try to indent
     * @param arr
     */
    public static void print(Object[][] arr){
        for (Object[] os: arr) {
            System.out.println(Arrays.toString(os));
        }
    }
}
