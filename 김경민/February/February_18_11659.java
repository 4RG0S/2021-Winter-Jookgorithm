import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class February_18_11659 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(line.nextToken());
    int M = Integer.parseInt(line.nextToken());
    int arr[] = new int[N];
    int sum[] = new int[N];
    line = new StringTokenizer(br.readLine(), " ");
    for(int i=0;i<N;i++) {
      int num = Integer.parseInt(line.nextToken());
      arr[i] = num;
      if (i == 0)
        sum[i] = num;
      else
        sum[i] = sum[i-1] + num;
    }
    for(int i=0;i<M;i++) {
      line = new StringTokenizer(br.readLine(), " ");
      int from = Integer.parseInt(line.nextToken()) - 1;
      int to = Integer.parseInt(line.nextToken()) - 1;

      if (from == 0)
        System.out.println(sum[to]);
      else
        System.out.println(sum[to] - sum[from - 1]);
    }
  }
}
