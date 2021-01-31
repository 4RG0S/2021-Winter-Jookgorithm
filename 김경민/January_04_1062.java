
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class January_04_1062 {
	
	static int max = 0;
	static boolean bitmask[] = new boolean[26];
	
	static boolean make_word(String data) {
		for(char ch : data.toCharArray()) {
			if(!bitmask[ch - 'a'])
				return false;
		}
		return true;
	}
	
	
	
	static void do_combi(String data[], int K, int mem) {
		if(K == 0) {
			int count = 0;
			for(int i=0;i<data.length;i++) {
				if(make_word(data[i]))
					count++;
			}
			if(count > max)
				max = count;
		} else {
			for(int i=mem;i<26;i++) {
				if(!bitmask[i]) {
					bitmask[i] = true;
					K--;
					do_combi(data, K, i);
					K++;
					bitmask[i] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(line.nextToken());
		int K = Integer.parseInt(line.nextToken());
		String data[] = new String[N];
		
		for(int i=0;i<N;i++) {
			data[i] = br.readLine();
		}
		bitmask[0] = true;
		bitmask[2] = true;
		bitmask[8] = true;
		bitmask[13] = true;
		bitmask[19] = true;
		if(K >= 5)
			do_combi(data, K - 5, 0);
		System.out.println(max);
	}

}
