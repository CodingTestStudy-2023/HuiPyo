import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        array[0] = 1;

        if (n > 1) array[1] = 3;
        Arrays.setAll(array, i -> i < 2 ? array[i] : (array[i - 1] + array[i - 2] * 2) % 10_007);
        System.out.println(array[array.length - 1]);
        scanner.close();
    }
}
