import java.util.Arrays;
import java.util.Random;

public class Zad11 {

    /*
    Wymiary tablicy dwuwymiarowej losujemy z przedziału <3,10>
    dopóki nie będzie kwadratowa. Elementy tablicy są losowane z przedziału <4, 20>.
    Wypisz na ekranie zestawienie numerów tych wierszy i kolumn,
    które mają sumy elementów różniące się o mniej niż 3.
     */

    static int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int[][] generateSquareArray(int sizeMin, int sizeMax, int minElement, int maxElement) {
        int rows, cols;
        do {
            rows = generate(sizeMin, sizeMax);
            cols = generate(sizeMin, sizeMax);
        } while (!(rows == cols));
        int[][] array = new int[rows][cols];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generate(minElement, maxElement);
            }
        }
        return array;
    }

    static void showArray(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

    static int sumElements(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null.");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    static void differenceLessThanThree(int[][] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null!!!");
        }
        int index = 0;
        int sum = sumElements(array[0]);
    }


    public static void main(String[] args) {

        int minSize = 3;
        int maxSize = 10;
        int minElement = 4;
        int maxElement = 20;

        int[][] array = generateSquareArray(minSize, maxSize, minElement, maxElement);
        showArray(array);


    }
}
