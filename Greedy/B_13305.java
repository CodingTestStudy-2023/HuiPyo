import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] array1 = new long[n - 1];
        long[] array2 = new long[n];

        Arrays.setAll(array1, i -> scanner.nextLong());
        Arrays.setAll(array2, j -> scanner.nextLong());
        if (array1[0] != 0 && array2[0] != 0) {
            long answer = array2[0] * array1[0];
            long min = array2[0];

            for (int i = 1; i < n - 1; i++) {
                min = Math.min(min, array2[i]);
                answer += min * array1[i];
            }
            System.out.println(answer);
        }
        scanner.close();
    }
}
