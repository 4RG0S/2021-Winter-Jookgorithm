import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long max = Long.MIN_VALUE;
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long temp;
		
		for(int i = 0; i <= n - k; i++) {
			temp = arr[i];
			for(int j = i + 1; j < i + k; j++)	temp += arr[j];
			if(temp > max)	max = temp;
		}
		
		System.out.println(max);
	}
}

