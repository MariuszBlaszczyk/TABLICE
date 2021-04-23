import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/* v
Pobierz od użytkownika rozmiar oraz elementy tablicy typu int.
Oblicz, ile w tablicy jest elementów, które są dzielnikami liczby,
którą wcześniej wylosujesz z przedziału <5, 100>.
 */
public class Zad5 {

    static int getArraySizeFromUser() {
        int number;
        var scanner = new Scanner(System.in);
        System.out.println("Enter the array size");
        number = scanner.nextInt();
        while ((number <= 0)) {
            System.out.println("Size must be greater than zero, please give it again:");
            number = scanner.nextInt();
        }
        return number;
    }

    static int getArrayElementsFromUser() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter the element of the array:");
        return scanner.nextInt();
    }

    static int generateNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[] generateArray() {
        System.out.println("Enter the data and create an array.\n");
        var size = getArraySizeFromUser();
        var array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getArrayElementsFromUser();
        }
        return array;
    }


    static int numberOfElementsDividedByNumber(int[] array, int number) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        var counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % number == 0) {
                counter++;
            }
        }
        return counter;
    }


    public static void main(String[] args) {

        int[] array = generateArray();
        System.out.println(Arrays.toString(array) + '\n');

        int min = 5;
        int max = 100;
        int number = generateNumber(min, max);
        System.out.println("The number drawn is: " + number);

        System.out.println("Number of elements that are divisors of a number:"
                + numberOfElementsDividedByNumber(array, number));

    }
}
