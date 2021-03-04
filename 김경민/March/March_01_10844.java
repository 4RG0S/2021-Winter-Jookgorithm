import java.util.Scanner;

public class March_01_10844 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    int sum[][] = new int[101][10];
    sum[1][0] = 0;
    for(int i=1;i<10;i++) {
      sum[1][i] = 1;
    }
    for(int i=2;i<=N;i++) {
      for(int j=0;j<10;j++) {
        if (j == 0)
          sum[i][j] = sum[i-1][j+1];
        else if (j == 9)
          sum[i][j] = sum[i-1][j-1];
        else
          sum[i][j] = (sum[i-1][j-1] + sum[i-1][j+1]) % 1000000000;
      }
    }
    int result = 0;
    for(int i=0;i<10;i++) {
      result = (result + sum[N][i]) % 1000000000;
    }
    System.out.println(result);
    scan.close();
  }
}
