import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        AtomicInteger answer = new AtomicInteger(0);
        Function<List<Integer>, Integer> calculate = list -> {
            int result = 0;

            for (int i = 0; i < array.length - 1; i++) {
                result += Math.abs(list.get(i) - list.get(i + 1));
            }
            return result;
        };
        Consumer<Stack<Integer>> backtracking = new Consumer<>() {
            @Override
            public void accept(Stack<Integer> stack) {
                if (stack.size() >= array.length) {
                    answer.set(Math.max(answer.get(), calculate.apply(stack.stream().mapToInt(val -> array[val]).boxed().collect(Collectors.toList()))));
                    return;
                }
                for (int i = 0; i < array.length; i++) {
                    if (stack.contains(i)) continue;
                    stack.push(i);
                    accept(stack);
                    stack.pop();
                }
            }
        };

        Arrays.setAll(array, val -> scanner.nextInt());
        backtracking.accept(new Stack<>());
        System.out.println(answer.get());
        scanner.close();
    }
}
