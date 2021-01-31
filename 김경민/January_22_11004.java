
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class January_22_11004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		int arr[] = new int[N];
		scan.nextLine();
		StringTokenizer line = new StringTokenizer(scan.nextLine(), " ");
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(line.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(arr[K-1]);
		scan.close();
	}

}
