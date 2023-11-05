import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int w = scanner.nextInt();
            int h = scanner.nextInt();

            if (w == 0 && h == 0) {
                scanner.close();
                break;
            }
            int[][] arrays = initArray(w, h, scanner);
            int answer = 0;

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (arrays[i][j] == 1) {
                        answer++;
                        bfs(new int[] {i, j}, arrays);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static int[][] initArray(int w, int h, Scanner scanner) {
        int[][] array = new int[h + 2][w + 2];

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }

    private static void bfs(int[] start, int[][] arrays) {
        Queue<int[]> queue = new LinkedList<>(List.of(start));

        while (!queue.isEmpty()) {
            int[] outed = queue.poll();
            int i = outed[0];
            int j = outed[1];
            arrays[i][j] = 2;

            for (int[] next : new int[][] {{i - 1, j}, {i - 1, j + 1}, {i, j + 1}, {i + 1, j + 1}, {i + 1, j}, {i + 1, j - 1}, {i, j - 1}, {i - 1, j - 1}}) {
                if (arrays[next[0]][next[1]] == 1) {
                    arrays[next[0]][next[1]] = 2;

                    queue.add(next);
                }
            }
        }
    }
}
