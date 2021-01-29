package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class January_22_16234 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(line.nextToken());
		int L = Integer.parseInt(line.nextToken());
		int R = Integer.parseInt(line.nextToken());
		int people[][] = new int[N][N];
		
		for(int i=0;i<N;i++) {
			line = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				people[i][j] = Integer.parseInt(line.nextToken());
			}
		}
		int count = 0;
		boolean visit[][] = new boolean[N][N];
		while(true) {
			
		}
		
	}

}
