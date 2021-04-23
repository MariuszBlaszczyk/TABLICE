
/*
Rozmiar oraz elementy tablicy są losowane z przedziału <10,30>.
Wypisz te elementy tablicy, które przy dzieleniu przez 5 dają resztę,
która jest większa od ostatniej cyfry dzielonego elementu tablicy.
!!!
Wszystkie liczby dzielone przez 5 mają taką samą resztę jak i cyfrę jedności, dlatego nic się nie wyświetli.
 */

import java.util.Arrays;
import java.util.Random;

public class Zad7 {

    static int generateArraySize(int min, int max) {
        if (min > max && min <= 0) {
            throw new IllegalArgumentException("Size must not be less than zero");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int generateArrayElements(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[] generateArray(int sizeMin, int sizeMax, int valueMin, int valueMax) {
        var size = generateArraySize(sizeMin, sizeMax);
        var array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateArrayElements(valueMin, valueMax);
        }
        return array;
    }

    static int unities(int number) {
        return number % 10;
    }


    static void showArrayElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null!!!");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 5 > unities(array[i])) {
                System.out.println(array[i]);
            }
        }
    }


    public static void main(String[] args) {

        int min = 10;
        int max = 30;
        int[] array = generateArray(min, max, min, max);
        System.out.println(Arrays.toString(array));
        System.out.println();
        showArrayElements(array);
    }
}
