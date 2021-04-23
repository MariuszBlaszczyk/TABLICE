/*
Wylosuj tablicę liczb całkowitych o elementach z przedziału <-30, 45>.
Rozmiar tablicy jest losowany z przedziału <9, 20>. Każdy element,
który jest liczbą ujemną zastąp wartością przeciwną do wartości tego elementu.
Pozostałe elementy zastąp wartością odwrotną do wartości tych elementów.
Wypisz na ekranie tak otrzymaną tablicę.

*/

import java.util.Arrays;
import java.util.Random;

public class Zad2 {

    static int generateNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static double[] generateArray(int sizeMin, int sizeMax, int valueMin, int valueMax) {
        int size = generateNumber(sizeMin, sizeMax);
        double[] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber(valueMin, valueMax);
        }
        return array;
    }

    static double[] replaceElements(double[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Array is null");
        }
        double[] modifiedNumbers = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                modifiedNumbers[i] = -numbers[i];
            } else if (numbers[i] > 0) {
                modifiedNumbers[i] = 1 / numbers[i];
            }
        }
        return modifiedNumbers;
    }

    public static void main(String[] args) {

        int valueMin = -30;
        int valueMax = 45;
        int sizeMin = 9;
        int sizeMax = 20;

        var numbers = generateArray(sizeMin, sizeMax, valueMin, valueMax);
        System.out.println(Arrays.toString(numbers));

        var replacedNumbers = replaceElements(numbers);
        System.out.println(Arrays.toString(replacedNumbers));
    }
}