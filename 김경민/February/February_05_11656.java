import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class February_05_11656 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    String arr[] = new String[line.length()];

    for(int i=0;i<line.length();i++) {
      String subtract = line.substring(i, line.length());
      arr[i] = subtract;
    }
    Arrays.sort(arr);
    for(int i=0;i<arr.length;i++) {
      System.out.println(arr[i]);
    }
  }
}
