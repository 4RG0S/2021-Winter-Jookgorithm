import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class February_02_1972 {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String line = br.readLine();
      boolean result = true;
      if (line.equals("*"))
        break;

      if(line.length() > 2) {
        for(int i=0;i<line.length() - 2;i++) {
          Set<String> set = new HashSet<>();

          for(int index=0;index<line.length() - i - 1;index++) {
            String pair = Character.toString(line.charAt(index)) + Character.toString(line.charAt(index + i + 1));
            if(set.contains(pair))
              result = false;
            set.add(pair);
          }
        }
      }
      System.out.println(result ? line + " is surprising." : line + " is NOT surprising.");
    }
  }
}
