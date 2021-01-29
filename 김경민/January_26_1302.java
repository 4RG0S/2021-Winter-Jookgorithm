package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class January_26_1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> map = new HashMap<>();
		HashMap<Integer, String> result = new HashMap<>();
		int largest = 0;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			int key;
			if(map.containsKey(line)) {
				map.put(line, map.get(line) + 1);
				key = map.get(line);
			}
			else {
				map.put(line, 1);
				key = map.get(line);
			}
			if(result.containsKey(key) && result.get(key).compareTo(line) > 0) {
				result.put(key, line);
				largest = (largest < key) ? key : largest;
			} else if(!result.containsKey(key)) {
				result.put(key, line);
				largest = (largest < key) ? key : largest;
			}
		}
		System.out.println(result.get(largest));
	}

}
