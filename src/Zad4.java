

/*
Wylosuj tablicę liczb całkowitych o elementach z przedziału <10, 45>.
Rozmiar tablicy jest losowany z przedziału <2, 40>.
Pobieraj od użytkownika dwie liczby a i b – zmienne int, dopóki nie zajdzie relacja a < b.
Wyznacz średnią arytmetyczną elementów tablicy o wartościach z przedziału <a,b>.
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad4 {

    static int generateNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Randm range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[] generateArray(int sizeMin, int sizeMax, int valueMin, int valueMax) {
        int size = generateNumbers(sizeMin, sizeMax);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumbers(valueMin, valueMax);
        }
        return array;
    }

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    static double calculateAverageElementsXToY(int[] array, int x, int y) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        if (x > y) {
            throw new IllegalArgumentException("A > B !!!");
        }
        double sum = 0;
        double counter = 0;
        Arrays.sort(array);
        for (double value : array) {
            if (value <= x && y <= value) {
                sum += value;
                counter++;
            }
        }
        return sum / counter;
    }


    public static void main(String[] args) {

        int sizeMin = 2;
        int sizeMax = 40;
        int valueMin = 10;
        int valueMax = 45;
        int[] array = generateArray(sizeMin, sizeMax, valueMin, valueMax);
        System.out.println(Arrays.toString(array));

        int a, b;
        do {
            System.out.println("Enter first value:");
            a = getNumberFromUser();
            System.out.println("Enter second value: ");
            b = getNumberFromUser();
            if (a > b) {
                System.out.println("A cannot be greater than B");
            }
        } while (!(a < b));


        double avg = calculateAverageElementsXToY(array, a, b);
        System.out.println("The arithmetic mean of the elements in the array from A to B is: " +
                avg);

    }
}
