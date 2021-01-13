package January;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class January_12_7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			String name = line.nextToken();
			String status = line.nextToken();
			
			if(status.equals("enter")) {
				set.add(name);
			} else if(status.equals("leave")) {
				set.remove(name);
			}
		}
		Object[] arr = set.toArray();
		Arrays.sort(arr, Collections.reverseOrder());
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i].toString() + '\n');
		}
		bw.flush();
	}

}
