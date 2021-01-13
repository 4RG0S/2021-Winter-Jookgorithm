import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[1000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())] = 1;
		}
		
		int x = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 1; i <= x / 2; i++) {
			if(arr[x - i] == 1 && arr[i] == 1 && 2*i != x)	count++;
		}
		
		System.out.println(count);
	}

}
