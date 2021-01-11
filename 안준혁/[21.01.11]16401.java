import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] snack = new int[n];
		st = new StringTokenizer(br.readLine());
		
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
			if(max < snack[i]) max = snack[i];
		}
		
		int left = 0;
		int right = max;
		int mid;
		int answer = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(mid == 0) {
				answer = 0;
				break;
			}
			if(can(snack, m, mid)) {
				if(mid > answer)	answer = mid;
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean can(int[] snack, int m, int mid) {
		long count = 0;
		for(Integer length : snack) {
			count += length / mid;
		}
		if(count >= m)	return true;
		else	return false;
	}
}