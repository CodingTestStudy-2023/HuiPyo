import java.util.*;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>() {
            {
                for (int i = 0; i < n; i++) {
                    put(i + 1, new ArrayList<>());
                }
                for (int j = 0; j < m; j++) {
                    int[] inputs = new int[] {scanner.nextInt(), scanner.nextInt()};

                    get(inputs[0]).add(inputs[1]);
                    get(inputs[1]).add(inputs[0]);
                }
            }
        };
        Set<Integer> visited = new HashSet<>(List.of(1));
        Consumer<Integer> dfs = new Consumer<>() {
            @Override
            public void accept(Integer v) {
                for (int next : map.getOrDefault(v, Collections.emptyList())) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    accept(next);
                }
            }
        };

        dfs.accept(1);
        System.out.println(visited.size() - 1);
        scanner.close();
    }
}
