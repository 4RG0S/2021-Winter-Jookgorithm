import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class February_16_2293 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");
    int n = Integer.parseInt(line.nextToken());
    int k = Integer.parseInt(line.nextToken());
    int sum[] = new int[k+1];
    int input[] = new int[n];

    for(int i=0;i<n;i++)
      input[i] = Integer.parseInt(br.readLine());

    sum[0] = 1;
    for (int i=0;i<n;i++) {
      for(int j=1;j<=k;j++) {
        if (j >= input[i])
          sum[j] = sum[j] + sum[j-input[i]];
      }
    }
    System.out.println(sum[k]);
  }
}
