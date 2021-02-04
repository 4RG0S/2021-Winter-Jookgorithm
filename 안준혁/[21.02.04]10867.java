import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		TreeSet<Integer> arr = new TreeSet<Integer>();

		int temp;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			temp = Integer.parseInt(st.nextToken());
			arr.add(temp);
		}
		
		for(Integer i: arr) {
			System.out.print(i + " ");
		}
	}
}

