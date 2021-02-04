import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class February_03_10527 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    HashMap<String, Integer> map = new HashMap<>();
    int result = 0;

    for(int i=0;i<N;i++) {
      String input = br.readLine();
      if(map.containsKey(input)) {
        map.put(input, map.get(input) + 1);
      } else {
        map.put(input, 1);
      }
    }
    for(int i=0;i<N;i++) {
      String input = br.readLine();
      if(map.containsKey(input) && map.get(input) > 0) {
        result++;
        map.put(input, map.get(input) - 1);
      }
    }
    System.out.println(result);
  }
}
