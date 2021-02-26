import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class February_26_10867 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer line = new StringTokenizer(br.readLine(), " ");
    HashSet<Integer> set = new HashSet<>();

    for(int i=0;i<N;i++) {
      set.add(Integer.parseInt(line.nextToken()));
    }
    Object[] arr = set.toArray();
    Arrays.sort(arr);

    for(int i=0;i<arr.length;i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
