package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class January_19_10451 {
	
	static boolean visit[];
	static List<List<Integer>> list;
	
	static void dfs(int here) {
		visit[here] = true;
		for(int there: list.get(here)) {
			if(visit[there])
				continue;
			dfs(there);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int k=0;k<T;k++) {
			int result = 0;
			list = new ArrayList<>();
			int N = Integer.parseInt(br.readLine());
			
			visit = new boolean[N+1];
			for(int i=0;i<N+1;i++) {
				list.add(new ArrayList<>());
			}
			
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			for(int i=1;i<=N;i++) {
				list.get(i).add(Integer.parseInt(line.nextToken()));
			}
			for(int i=1;i<=N;i++) {
				if(!visit[i]) {
					result++;
					dfs(i);
				}
			}
			System.out.println(result);
		}
	}

}
