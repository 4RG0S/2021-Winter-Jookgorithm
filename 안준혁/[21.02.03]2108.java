import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		int temp;
		double sum = 0;
		for(int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			arr.add(temp);
			sum += temp;
		}

		Collections.sort(arr);
		
		int[] mode = new int[8001];
		
		for(Integer i : arr) {
			if(i < 0) {
				mode[4000 - i]++;
			} else {
				mode[i]++;
			}
		}
		
		int max = 0;
		int second = 0;
		int rMode = 0;
		
		for(int i = 8000; i > 4000; i--) {
			if(mode[i] == max && second == 0) {
				second++;
				rMode = 4000 - i;
			} else if(mode[i] > max) {
				max = mode[i];
				rMode = 4000 - i;
				second = 0;
			}
		}
		
		for(int i = 0; i < 4001; i++) {
			if(mode[i] == max && second == 0) {
				second++;
				rMode = i;
			} else if(mode[i] > max) {
				max = mode[i];
				rMode = i;
				second = 0;
			}
		}
		
		System.out.println(String.format("%.0f", sum / n));
		System.out.println(arr.get(n/2));
		System.out.println(rMode);
		System.out.println(arr.get(n - 1) - arr.get(0));
	}
}

