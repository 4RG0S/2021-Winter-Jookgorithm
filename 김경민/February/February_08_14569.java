import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class February_08_14569 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    long subjects[] = new long[N];
    for(int i=0;i<N;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(line.nextToken());
      long sum = 0;
      for(int j=0;j<k;j++) {
        sum += Math.pow(2, Integer.parseInt(line.nextToken()));
      }
      subjects[i] = sum;
    }
    int M = Integer.parseInt(br.readLine());
    long students[] = new long[M];
    for(int i=0;i<M;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine());
      int p = Integer.parseInt(line.nextToken());
      long sum = 0;
      for(int j=0;j<p;j++) {
        sum += Math.pow(2, Integer.parseInt(line.nextToken()));
      }
      students[i] = sum;
      int result = 0;
      for(int j=0;j<N;j++) {
        if((students[i] & subjects[j]) == subjects[j]) {
          result++;
        }
      }
      System.out.println(result);
    }
  }
}
