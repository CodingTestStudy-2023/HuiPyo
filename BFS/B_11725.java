import java.util.*;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, List<Integer>> graphMap = new HashMap<>() {
            {
                for (int i = 0; i < n - 1; i++) {
                    int[] inputs = new int[] {scanner.nextInt(), scanner.nextInt()};

                    computeIfAbsent(inputs[0], integer -> new ArrayList<>());
                    get(inputs[0]).add(inputs[1]);
                    computeIfAbsent(inputs[1], integer -> new ArrayList<>());
                    get(inputs[1]).add(inputs[0]);
                }
            }
        };
        final Map<Integer, Integer> parentMap = new HashMap<>();
        BiConsumer<Integer, Set<Integer>> dfs = new BiConsumer<>() {
            @Override
            public void accept(Integer v, Set<Integer> visited) {
                for (int next : graphMap.get(v)) {
                    if (visited.contains(next)) continue;
                    parentMap.put(next, v);
                    visited.add(next);
                    accept(next, visited);
                }
            }
        };

        dfs.accept(1, new HashSet<>(List.of(1)));
        for (int k = 2; k <= n; k++) {
            System.out.println(parentMap.get(k));
        }
        scanner.close();
    }
}
