

/*
Rozmiar tablicy losowany jest z przedziału <4, 10>. Pobieraj od użytkownika elementy tablicy dotąd,
dopóki każdy kolejny element tablicy, począwszy od drugiego, nie będzie większy od elementu poprzedniego.
Wypisz elementy otrzymanej tablicy.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad8 {

    static int generateArraySize(int min, int max) {
        if (min > max && min <= 0) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int getArrayElementFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number value:");
        return scanner.nextInt();
    }

    static int[] generateArray(int sizeMin, int sizeMax) {
        int size = generateArraySize(sizeMin, sizeMax);
        System.out.println("Size array is: " + size);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            do {
                array[i] = getArrayElementFromUser();
            } while (!(array[i - 1] < i));
        }
        return array;
    }


    public static void main(String[] args) {

        int minSize = 4;
        int maxSize = 10;

        int[] array = generateArray(minSize, maxSize);
        System.out.println(Arrays.toString(array));

    }
}
