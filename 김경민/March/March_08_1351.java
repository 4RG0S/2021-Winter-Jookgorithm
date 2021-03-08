import java.util.HashMap;
import java.util.Scanner;

public class March_08_1351 {
  static HashMap<Long, Long> map;

  static long dp(long N, long P, long Q) {
    if (map.containsKey(N))
      return map.get(N);
    long sum = dp(N/P, P, Q) + dp(N/Q, P, Q);
    map.put(N, sum);
    return sum;
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    long N = scan.nextLong();
    long P = scan.nextLong();
    long Q = scan.nextLong();

    map = new HashMap<>();
    map.put((long)0, (long)1);
    System.out.println(dp(N, P, Q));
  }
}
