import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        AtomicInteger answer = new AtomicInteger(Integer.MAX_VALUE);
        int[][] arrays = new int[n][n];
        Set<Integer> numbers = new HashSet<>() { { for (int i = 0; i < n; i++) add(i); } };
        BiConsumer<Stack<Integer>, Integer> combination = new BiConsumer<>() {
            @Override
            public void accept(Stack<Integer> stack, Integer start) {
                for (int i = start; i < n; i++) {
                    if (stack.contains(i)) continue;
                    stack.push(i);
                    if (stack.size() < n / 2) accept(stack, i);
                    else answer.set(Math.min(answer.get(), getSubtractSum(Set.of(new HashSet<>(stack), new HashSet<>(numbers) { { removeAll(stack); }}), arrays)));
                    stack.pop();
                }
            }
        };

        Arrays.setAll(arrays, value -> {
            int[] arr = new int[n];

            Arrays.setAll(arr, i -> scanner.nextInt());
            return arr;
        });
        combination.accept(new Stack<>(), 0);
        System.out.println(answer);
        scanner.close();
    }

    private static int getSubtractSum(Set<Set<Integer>> lists, int[][] array) {
        Iterator<Set<Integer>> it = lists.iterator();
        List<Integer> first = new ArrayList<>(it.next());
        List<Integer> last = new ArrayList<>(it.next());
        int firstSum = combinationSum(first, array);
        int lastSum = combinationSum(last, array);
        return Math.max(firstSum, lastSum) - Math.min(firstSum, lastSum);
    }

    private static int combinationSum(List<Integer> sliced, int[][] array) {
        int result = 0;

        for (int i = 0; i < sliced.size() - 1; i++) {
            for (int j = i + 1; j < sliced.size(); j++) {
                result += array[sliced.get(i)][sliced.get(j)];
                result += array[sliced.get(j)][sliced.get(i)];
            }
        }
        return result;
    }
}
