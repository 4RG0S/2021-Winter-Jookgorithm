import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class February_23_9536 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for(int i=0;i<T;i++) {
      StringTokenizer line = new StringTokenizer(br.readLine(), " ");
      HashSet<String> set = new HashSet<>();

      while(true) {
        String input = br.readLine();
        if (input.equals("what does the fox say?"))
          break;
        String split[] = input.split(" ");
        set.add(split[2]);
      }
      while(line.hasMoreTokens()) {
        String text = line.nextToken();
        if (!set.contains(text))
          System.out.print(text + " ");
      }
      System.out.println();
    }
  }
}
