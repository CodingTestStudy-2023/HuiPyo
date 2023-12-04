import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println(IntStream.iterate(0, i -> i <= input, i -> i + 5).flatMap(i -> IntStream.iterate(0, j -> j <= input, j -> j + 3).takeWhile(j -> i + j <= input).filter(j -> i + j == input).map(j -> i / 5 + j / 3)).boxed().reduce(-1, (acc, i) -> i));
        sc.close();
    }
}
