import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        
        backtracking(n, stack);
        scanner.close();
    }

    private static void backtracking(int n, Stack<Integer> stack) {
        for (int i = 1; i < 4; i++) {
            if (isContainsToSame(stack, i)) continue;
            stack.push(i);
            if (stack.size() < n) backtracking(n, stack);
            else printAndExit(stack);
            stack.pop();
        }
    }

    private static boolean isContainsToSame(Stack<Integer> stack, int n) {
        String s = joinToString(stack) + n;
        int length = s.length() % 2 == 0 ? s.length() : s.length() - 1;

        while (length > 1) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                String first = s.substring(i, i + length / 2);
                String last = s.substring(i + length / 2, i + length);

                if (first.equals(last)) return true;
            }
            length -= 2;
        }
        return false;
    }

    private static void printAndExit(Stack<Integer> stack) {
        System.out.println(joinToString(stack));
        System.exit(0);
    }

    private static String joinToString(List<Integer> list) {
        return String.join("", new ArrayList<>() { { for (int n : list) add(String.valueOf(n)); } });
    }
}
