import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class FunctionalProgramming {
  private static Integer number;

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Integer accumulator = 0;
    Integer sum = numbers.stream()
        .reduce(accumulator, (a, b) -> a + b);

    System.out.println(sum);

    sum = numbers.stream()
        .reduce((a, b) -> a + b).orElse(0);

    System.out.println(sum);


    System.out.println(
        numbers.stream()
            .filter(e -> e > 3)
            .filter(e -> e % 2 == 0)
            .map(e -> e * 2)
            .findFirst()
            .orElse(-1)
    );

    Function<Integer, Double> f = e -> ((double) (e + 1));

    int max = numbers.stream().reduce(Math::max).orElse(-1);
    numbers = Arrays.asList(new Integer[0]);
    int min = 0;
    try {
      min = numbers.stream().reduce(Math::min).orElseThrow(Exception::new);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println(min);
    System.out.println(max);



    System.out.println(apply(f, 5));
  }

  private static double apply(Function<Integer, Double> f, int x) {
    return f.apply(x);
  }
}

