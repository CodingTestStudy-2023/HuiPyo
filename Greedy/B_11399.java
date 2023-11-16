import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];

        Arrays.setAll(array, i -> scanner.nextInt());
        Arrays.sort(array);
        System.out.println(IntStream.range(0, n).map(i -> Arrays.stream(Arrays.copyOf(array, i + 1)).sum()).sum());
        scanner.close();
    }
}
