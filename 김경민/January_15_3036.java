
import java.util.Scanner;

public class January_15_3036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int arr[] = new int[N];
		int num = scan.nextInt();
		for(int i=1;i<N;i++) {
			arr[i] = scan.nextInt();
			int gcd = 1;
			for(int j=2;j<Integer.max(num, arr[i]);j++) {
				if(num % j == 0 && arr[i] % j == 0)
					gcd = j;
			}
			System.out.println(num/gcd + "/" + arr[i]/gcd);
		}
		scan.close();
		
	}

}