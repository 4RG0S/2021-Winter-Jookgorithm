import java.util.HashSet;
import java.util.Scanner;

public class February_19_11478 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String line = scan.nextLine();

    HashSet<String> set = new HashSet<>();
    for(int start=0;start<line.length();start++) {
      for(int end = start;end<line.length();end++) {
        set.add(line.substring(start, end + 1));
      }
    }
    System.out.println(set.size());
    scan.close();
  }
}
