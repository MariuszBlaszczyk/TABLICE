

/* v
Pobierz od użytkownika rozmiar tablicy i utwórz tablicę elementów typu int.
Elementy tablicy losujesz z przedziału <-10, 20>, jeżeli element tablicy znajduje się
pod indeksem parzystym lub z przedziału <30,50>, jeżeli element tablicy znajduje się
pod indeksem nieparzystym. Oblicz sumę elementów tablicy,
które dzielą się przez indeks, pod którym się znajdują.
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad6 {

    static int getArraySizeFromUser() {
        int number;
        var scanner = new Scanner(System.in);
        System.out.println("Enter the array size");
        number = scanner.nextInt();
        while (number <= 0) {
            System.out.println("Size must be greater than zero, please give it again:");
            number = scanner.nextInt();
        }
        return number;
    }

    static int generateNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) - min;
    }

    static int[] generateArray(int evenMin, int evenMax, int oddMin, int oddMax) {
        var sizeArray = getArraySizeFromUser();
        var array = new int[sizeArray];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = generateNumber(evenMin, evenMax);
            } else if (array[i] % 2 != 0) {
                array[i] = generateNumber(oddMin, oddMax);
            }
        }
        return array;
    }

    static int sumElementsDivideByIndex (int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        var sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % array[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        int minEven = -10;
        int maxEven = 20;
        int minOdd = 30;
        int maxOdd = 50;

        var array = generateArray(minEven, maxEven, minOdd, maxOdd);
        System.out.println(Arrays.toString(array));

        System.out.println("The sum is: " + sumElementsDivideByIndex(array));
    }

}






