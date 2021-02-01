
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class January_18_11725 {
	
	static List<List<Integer>> list = new ArrayList<>();
	static int parents[];
	static boolean visit[];

	static void dfs(int here) throws IOException {
		for(int there: list.get(here)) {
			if(visit[there])
				continue;
			visit[there] = true;
			parents[there] = here;
			dfs(there);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit = new boolean[N+1];
		parents = new int[N+1];
		for(int i=0;i<N+1;i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			
			int from = Integer.parseInt(line.nextToken());
			int to = Integer.parseInt(line.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}
		visit[1] = true;
		dfs(1);
		//System.out.println("========");
		for(int i=2;i<=N;i++) {
			System.out.println(parents[i]);
		}
	}

}
