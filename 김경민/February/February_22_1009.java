import java.util.Scanner;

public class February_22_1009 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    for(int i=0;i<T;i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      int temp = a % 10;
      for(int j=1;j<b;j++) {
        temp = (temp * a) % 10;
      }
      if (temp == 0)
        System.out.println(10);
      else
        System.out.println(temp);
    }
    scan.close();
  }
}
