package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class January_25_17471 {

	static boolean visit[];
	static int population[];
	static List<List<Integer>> list = new ArrayList<>();
	static int contain_vote;
	static int result = Integer.MAX_VALUE;

	static int bfs(Stack<Integer> area) {
		Queue<Integer> q = new LinkedList<>();
		int count = population[area.get(0)];
		q.add(area.get(0));
		visit[area.get(0)] = true;
		while (!q.isEmpty()) {
			int here = q.poll();
			for (int there : list.get(here)) {
				if (visit[there] || !area.contains(there))
					continue;
				contain_vote++;
				count += population[there];
				visit[there] = true;
				q.add(there);
			}
		}
		return count;
	}

	static void make_pair(Stack<Integer> A) {
		Stack<Integer> B = new Stack<>();
		for (int i = 1; i < visit.length; i++) {
			if (!A.contains(i))
				B.add(i);
		}
		visit = new boolean[visit.length];
		contain_vote = 2;
		int a = bfs(A);
		int b = bfs(B);
		if (contain_vote == visit.length - 1) {
			result = (result > Math.abs(a - b)) ? Math.abs(a - b) : result;
		}
	}

	static void combination(int n, int r, int peek, Stack<Integer> stack) {
		if (stack.size() == r) {
			make_pair(stack);
		} else {
			for (int i = peek + 1; i < visit.length; i++) {
				stack.add(i);
				combination(n, r, i, stack);
				stack.pop();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		visit = new boolean[N + 1];
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		list.add(new ArrayList<>());
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(line.nextToken());
			list.add(new ArrayList<>());
		}
		for (int i = 1; i <= N; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(line.nextToken());
			for (int j = 0; j < count; j++) {
				list.get(i).add(Integer.parseInt(line.nextToken()));
			}
		}
		for (int i = 1; i < N; i++) {
			combination(N, i, 0, new Stack<>());
		}
		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}

}
