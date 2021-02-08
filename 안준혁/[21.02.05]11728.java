import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int temp;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			temp = Integer.parseInt(st.nextToken());
			arr.add(temp);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			temp = Integer.parseInt(st.nextToken());
			arr.add(temp);
		}

		Collections.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(Integer i: arr) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}

