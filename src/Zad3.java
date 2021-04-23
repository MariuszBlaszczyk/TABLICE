

/* v
Z elementów tablicy typu double o rozmiarze i wartościach pobranych od użytkownika wyznacz średnią arytmetyczną,
którą następnie pomnóż razy dwa. Tak otrzymany wynik zapisz do zmiennej x.
Wszystkie elementy tablicy zwiększ o 10% wartości zmiennej x.
 */


import java.util.Arrays;
import java.util.Scanner;

public class Zad3 {

    static int getArraySizeFromUser() {
        int number;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the array size");
        number = scan.nextInt();
        while (number <= 0) {
            System.out.println("Size must be greater than zero, please give it again:");
            number = scan.nextInt();
        }
        return number;
    }

    static double getArrayElementsFromUser() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the element of the array:");
        return scan.nextDouble();
    }

    static double[] generateArray() {
        System.out.println("Enter the data and create an array.\n");
        var size = getArraySizeFromUser();
        var array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = getArrayElementsFromUser();
        }
        return array;
    }

    static double calculateAverageMultipliedByTwo(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null!!!");
        }
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        double avg = sum / array.length;
        return avg * 2;
    }

    static double[] elementsLargerByTenPercent(double[] array, double multiplier) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }
        multiplier = calculateAverageMultipliedByTwo(array);
        double tensPercent = (multiplier * 0.1);
        double[] newArray = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = (array[i] + tensPercent);
        }
        return newArray;
    }

    public static void main(String[] args) {

        var array = generateArray();
        System.out.println("Array: " + Arrays.toString(array));
        var avg = calculateAverageMultipliedByTwo(array);
        System.out.println("\nThe average multiplied by two is: " + avg + "\n");
        var newArray = elementsLargerByTenPercent(array, avg);
        System.out.println("Array with elements largest by ten percent: " + Arrays.toString(newArray));


    }
}

