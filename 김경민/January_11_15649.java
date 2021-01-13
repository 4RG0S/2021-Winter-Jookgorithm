package January;

import java.util.Scanner;
import java.util.Stack;

public class January_11_15649 {
	
	static boolean used[];
	
	static void combi(int N, int R, int picked, Stack<Integer> mem) {
		if(mem.size() == R) {
			for(int i=0;i<mem.size();i++) {
				System.out.print(mem.get(i) + " ");
			}
			System.out.println();
		} else {
			for(int i=1;i<=N;i++) {
				if(used[i])
					continue;
				mem.add(i);
				used[i] = true;
				combi(N, R, i, mem);
				mem.pop();
				used[i] = false;
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int M = scan.nextInt();
		used = new boolean[N+1];
		
		combi(N, M, 0, new Stack<Integer>());
	}

}
