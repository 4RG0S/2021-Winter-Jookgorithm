import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class February_24_2435 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer line = new StringTokenizer(br.readLine());

    int å = Integer.parseInt(line.nextToken());
    int ß = Integer.parseInt(line.nextToken());
    int temperature[] = new int[å];

    line = new StringTokenizer(br.readLine());
    for(int i=0;i<å;i++) {
      temperature[i] = Integer.parseInt(line.nextToken());
    }
    int result = Integer.MIN_VALUE;
    for(int i=0;i<å-ß+1;i++) {
      int sum = 0;
      for(int j=i;j<i+ß;j++) {
        sum += temperature[j];
      }
      result = (sum > result) ? sum : result;
    }
    System.out.println(result);
  }
}
