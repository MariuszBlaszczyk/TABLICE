import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Zad12 {

    /*
    Wymiary tablicy dwuwymiarowej podaje użytkownik dopóki ilość wierszy nie będzie liczbą parzystą większą od 2.
    Ilość kolumn jest pobierana dopóki nie będzie liczbą większa od 4.
    Elementy tablicy są losowane z przedziału <5, 25>. Następnie zaimplementuj drugą tablicę
    o identycznych wymiarach co pierwsza. Elementy tej tablicy to sumy cyfr elementów występujących
    na odpowiadających pozycjach w tablicy pierwszej. Następnie dodaj dwie tablice
    do siebie według zasady pierwszy wiersz pierwszej tablicy z ostatnim wierszem drugiej tablicy,
    drugi wiersz pierwszej tablicy z przedostatnim wierszem drugiej tablicy itd.
     */

    static int generate(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Random range is not correct");
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    static int getNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        int number = 0;
        boolean error = true;
        do {
            try {
                number = scan.nextInt();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("You must give a number");
                scan.nextLine();
            }
        } while ((error));
        return number;
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }

    static int[][] createArray(int minElement, int maxElement) {
        int rows, cols;
        do {
            rows = getNumberFromUser();
        } while (!(isEven(rows) && rows > 2));
        do {
            cols = getNumberFromUser();
        } while (!(cols > 4));
        int[][] array = new int[rows][cols];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = generate(minElement, maxElement);
            }
        }
        return array;
    }

    public static void main(String[] args) {

        int minElements = 5;
        int maxElements = 25;
    }
}
