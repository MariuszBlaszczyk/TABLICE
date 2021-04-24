
/*
Rozmiar tablicy losowany jest z przedziału <9, 33>. Losuj kolejne elementy tablicy z przedziału <2, 30>
dopóki nie będą liczbą podzielną przez 3.
 */

import java.util.Arrays;
import java.util.Random;

public class Zad9 {

    static int generateArraySize(int min, int max) {
        if (min > max && min <= 0) {
            throw new IllegalArgumentException("Size must not be less than zero");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int generateArrayElement(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[] generateArray(int sizeMin, int sizeMax, int valueMin, int valueMax) {
        int size = generateArraySize(sizeMin, sizeMax);
        int[] array = new int[size];
        System.out.println("Size array is: " + size + "." + "\n");
        int number;
        for (int i = 0; i < array.length; i++) {
            do {
                number = generateArrayElement(valueMin, valueMax);
            } while (!(array[i] % 3 == 0));
            array[i] = number;
        }
        return array;
    }

    public static void main(String[] args) {

        int sizeMin = 9;
        int sizeMax = 33;
        int valueMin = 2;
        int valueMax = 30;

        int[] array = generateArray(sizeMin, sizeMax, valueMin, valueMax);
        System.out.println(Arrays.toString(array));
    }
}
