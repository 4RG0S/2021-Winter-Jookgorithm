package January;

import java.util.Scanner;

public class January_14_1292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int from = scan.nextInt();
		int to = scan.nextInt();
		int arr[] = new int[1000];
		int index = 1;
		int count = index;
		for(int i=0;i<1000;i++) {
			arr[i] = index;
			count--;
			if(count == 0)
				count = ++index;
		}
		
		int sum = 0;
		for(int i=from-1;i<=to-1;i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}

}
