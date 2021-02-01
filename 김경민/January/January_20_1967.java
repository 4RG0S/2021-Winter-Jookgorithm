package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class January_20_1967 {

	static class link {
		int dest, val;

		public link(int dest, int val) {
			this.dest = dest;
			this.val = val;
		}
	}

	static List<List<link>> list = new ArrayList<>();
	static int max = 0;
	static boolean visit[];

	static void dfs(int here, int sum) {
		if (sum > max)
			max = sum;
		for (link temp : list.get(here)) {
			if (visit[temp.dest])
				continue;
			visit[temp.dest] = true;
			dfs(temp.dest, sum + temp.val);
			visit[temp.dest] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> leaf = new HashSet<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			StringTokenizer line = new StringTokenizer(br.readLine(), " ");
			int parent = Integer.parseInt(line.nextToken());
			int child = Integer.parseInt(line.nextToken());
			int value = Integer.parseInt(line.nextToken());
			if (leaf.contains(parent))
				leaf.remove(parent);
			leaf.add(child);

			list.get(parent).add(new link(child, value));
			list.get(child).add(new link(parent, value));
		}
		Iterator<Integer> iter = leaf.iterator();
		while (iter.hasNext()) {
			visit = new boolean[n + 1];
			int next = iter.next();
			visit[next] = true;
			dfs(next, 0);
		}
		System.out.println(max);

	}

}
