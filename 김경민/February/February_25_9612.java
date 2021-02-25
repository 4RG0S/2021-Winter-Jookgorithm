import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class February_25_9612 {
  public static void main(String args[]) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    HashMap<String, Integer> map = new HashMap<>();
    int max = 0;

    for(int i=0;i<N;i++) {
      String input = br.readLine();
      if(map.containsKey(input)) {
        map.put(input, map.get(input) + 1);
      } else {
        map.put(input, 1);
      }
      max = (max < map.get(input)) ? map.get(input) : max;
    }

    ArrayList<String> list = new ArrayList<>();
    for (String key : map.keySet()) {
      if (map.get(key) == max)
        list.add(key);
    }
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list.get(0) + " " + map.get(list.get(0)));
  }
}
