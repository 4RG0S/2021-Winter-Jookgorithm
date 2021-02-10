import java.util.Scanner;

public class February_10_13241 {
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    long A = scan.nextLong();
    long B = scan.nextLong();
    long result = 0;

    for(int i=1;i<=B;i++) {
      if((A * i) % B == 0) {
        result = A * i;
        break;
      }
    }
    System.out.println(result);
    scan.close();
  }
}
