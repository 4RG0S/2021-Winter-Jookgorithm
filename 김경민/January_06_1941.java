package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class January_06_1941 {
	
	static int result = 0;
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static boolean som[][];
	
	static class dot{
		int x, y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static void validate(Stack<Integer> mem) {
		int count = 0;
		int count_som = 0;
		boolean visited[][] = new boolean[5][5];
		for(int i=0;i<mem.size();i++) {
			int num = mem.get(i);
			visited[num/5][num%5] = true;
		}
		Queue<dot> q = new LinkedList<>();
		q.add(new dot(mem.get(0)%5, mem.get(0)/5));
		visited[mem.get(0)/5][mem.get(0)%5] = false;
		if(som[mem.get(0)/5][mem.get(0)%5])
			count_som++;
		while(!q.isEmpty()) {
			dot temp = q.poll();
			count++;
			for(int i=0;i<4;i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				if(0 <= tx && tx < 5 && 0 <= ty && ty < 5 && visited[ty][tx]) {
					visited[ty][tx] = false;
					if(som[ty][tx])
						count_som++;
					q.add(new dot(tx, ty));
				}
			}
		}
		//System.out.println(count);
		if(count == 7 && count_som >= 4) {
			result++;
		}
	}
	
	static void combination(int N, int R, int picked, Stack<Integer> mem) {
		if(R == 0) {
			validate(mem);
		} else {
			for(int i=picked + 1;i<N;i++) {
				mem.add(i);
				combination(N, R - 1, i, mem);
				mem.pop();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		som = new boolean[5][5];
		for(int i=0;i<5;i++) {
			String line = br.readLine();
			for(int j=0;j<5;j++) {
				if(line.charAt(j) == 'S')
					som[i][j] = true;
			}
		}
		combination(25, 7, -1, new Stack<Integer>());
		System.out.println(result);
	}

}
