import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class February_09_1940 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    StringTokenizer line = new StringTokenizer(br.readLine());
    HashSet<Integer> set = new HashSet<>();
    int arr[] = new int[N];

    for(int i=0;i<N;i++) {
      int input = Integer.parseInt(line.nextToken());
      set.add(input);
      arr[i] = input;
    }

    int result = 0;
    for(int i=0;i<N;i++) {
      if (set.contains(M - arr[i]))
        result++;
    }
    System.out.println(result / 2);
  }
}
