package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class January_21_2206 {

	static class dot {
		int x, y, count;
		boolean broken;

		public dot(int x, int y, boolean broken, int count) {
			this.x = x;
			this.y = y;
			this.broken = broken;
			this.count = count;
		}
	}

	static boolean wall[][];
	static boolean visit[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		int brokenMin[][] = new int[N][M];
		int unbrokenMin[][] = new int[N][M];
		wall = new boolean[N][M];
		visit = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				wall[i][j] = input.charAt(j) == '0' ? false : true;
				brokenMin[i][j] = Integer.MAX_VALUE;
				unbrokenMin[i][j] = Integer.MAX_VALUE;
			}
		}

		Queue<dot> q = new LinkedList<>();
		int result = Integer.MAX_VALUE;
		q.add(new dot(0, 0, false, 1));
		while (!q.isEmpty()) {
			dot temp = q.poll();
			if (temp.y == N - 1 && temp.x == M - 1) {
				result = (result > temp.count) ? temp.count : result;
			}
			for (int i = 0; i < 4; i++) {
				int tx = temp.x + dx[i];
				int ty = temp.y + dy[i];
				if (0 <= tx && tx < M && 0 <= ty && ty < N) {
					if (temp.broken && wall[ty][tx])
						continue;
					if (wall[ty][tx] && temp.count < brokenMin[ty][tx]) {
						brokenMin[ty][tx] = temp.count;
						q.add(new dot(tx, ty, true, temp.count + 1));
					} else if (!wall[ty][tx]
							&& temp.count < ((temp.broken) ? brokenMin[ty][tx] : unbrokenMin[ty][tx])) {
						if (temp.broken)
							brokenMin[ty][tx] = temp.count;
						else
							unbrokenMin[ty][tx] = temp.count;

						q.add(new dot(tx, ty, temp.broken, temp.count + 1));
					}
				}
			}
		}
		System.out.println((result == Integer.MAX_VALUE) ? -1 : result);
	}

}
