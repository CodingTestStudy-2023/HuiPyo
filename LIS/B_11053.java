import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>() {
            {
                for (int i = 0; i < n; i++) add(scanner.nextInt());
            }
        };
        int answer = 0;
        int[] memo = new int[n];
        Function<Integer, Integer> recursion = new Function<>() {
            @Override
            public Integer apply(Integer start) {
                if (start < 0)
                    return 0;
                if (memo[start] != 0)
                    return memo[start];
                else {
                    int count = 1;

                    for (int i = start + 1; i < list.size(); i++) if (list.get(i) > list.get(start)) {
                        count = Math.max(count, apply(i) + 1);
                    }
                    return memo[start] = count;
                }
            }
        };

        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, recursion.apply(j));
        }
        System.out.println(answer);
        scanner.close();
    }
}
