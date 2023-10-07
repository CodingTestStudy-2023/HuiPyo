import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] array = new int[n];
        int answer = 0;

        Arrays.setAll(array, val -> scanner.nextInt());
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    int sum = array[i] + array[j] + array[k];

                    if (sum <= m) answer = Math.max(answer, sum);
                }
            }
        }
        System.out.println(answer);
        scanner.close();
    }
}
