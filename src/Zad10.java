

/*
Rozmiar tablicy pobierany jest od użytkownika. Elementy tablicy są losowane z przedziału <a,b>.
Liczby a i b to wartości typu int pobierane od użytkownika, dopóki nie będzie spełniony warunek a < b.
Wypisz z tablicy wszystkie te elementy, które posiadają parzysty indeks i są podzielne
przez wartość wyrażenia b – a
 */


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Zad10 {

    static int getArraySizeFromUser() {
        int number;
        var scan = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        number = scan.nextInt();
        while (number <= 0) {
            System.out.println("Size must be greater than zero, please give it again:");
            number = scan.nextInt();
        }
        return number;
    }

    static int generateNumbers(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static void generateArrayAndShowElements() {
        Scanner scan = new Scanner(System.in);
        int size = getArraySizeFromUser();
        int[] array = new int[size];
        int number1, number2;
        do {
            System.out.println("Enter the first value");
            number1 = scan.nextInt();
            System.out.println("Enter the second value");
            number2 = scan.nextInt();
            if (number1 > number2) {
                System.out.println("A cannot be greater than B");
            }
        } while (number1 > number2);
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumbers(number1, number2);
        }
        System.out.println(Arrays.toString(array));
        int number3 = number2 - number1;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 && array[i] % number3 == 0) {
                System.out.println(array[i]);;
            }
        };
    }

    public static void main(String[] args) {

        generateArrayAndShowElements();

    }
}
