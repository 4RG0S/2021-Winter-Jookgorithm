import java.util.Scanner;

public class February_22_11051 {
  static int result[][];
  static int nCr(int N, int R) {
    if (result[N][R] != 0)
      return result[N][R];
    if (N == R || R == 0)
      return result[N][R] = 1;
    if (R == 1)
      return result[N][R] = N;
    return result[N][R] = (nCr(N - 1, R) + nCr(N - 1, R - 1)) % 10007;
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int K = scan.nextInt();
    result = new int[1001][1001];
    System.out.println(nCr(N, K));
    scan.close();
  }
}
