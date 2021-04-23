/* v
Wylosuj tablicę liczb całkowitych o elementach z przedziału <10,30> i rozmiarze podanym przez użytkownika.
Oblicz sumę tych elementów tablicy, które przy dzieleniu przez 5 dają resztę będącą liczbą parzystą.
Wypisz na ekranie tak otrzymaną tablicę.
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad1 {

    static int generateNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int getNumberFromUser() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter number value:");
        return scanner.nextInt();
    }

    static int[] generateArray(int size, int min, int max) {
        if (size <= 0) {
            throw new IllegalArgumentException("Array has incorrect size");
        }
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = generateNumbers(min, max);
        }
        return arr;
    }

    static int sumEvenElementsDividedByFive(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Arrays is null");
        }

        int sum = 0;
        for (int number : array) {
            if ((number % 5) % 2 == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int min = 10;
        int max = 30;
        int size = getNumberFromUser();

        int[] arr = generateArray(size, min, max);
        System.out.println(Arrays.toString(arr));

        int sum = sumEvenElementsDividedByFive(arr);
        System.out.println("Sum of the elements of the array that produce an even remainder when divided by five is "
                + sum);

    }
}
