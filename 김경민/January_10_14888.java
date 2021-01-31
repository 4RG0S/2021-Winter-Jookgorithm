
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class January_10_14888 {
	
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int num[];
	
	static void backtrack(int plus, int minus, int multy, int divide, int mem, int index) {
		if(plus == 0 && minus == 0 && multy == 0 && divide == 0) {
			max = (mem > max) ? mem : max;
			min = (mem < min) ? mem : min;
		}
		if(plus > 0)
			backtrack(plus - 1, minus, multy, divide, mem + num[index], index + 1);
		if(minus > 0)
			backtrack(plus, minus - 1, multy, divide, mem - num[index], index + 1);
		if(multy > 0)
			backtrack(plus, minus, multy - 1, divide, mem * num[index], index + 1);
		if(divide > 0)
			backtrack(plus, minus, multy, divide - 1, mem / num[index], index + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer line = new StringTokenizer(br.readLine());
		num = new int[N];
		int operator[] = new int[4];
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(line.nextToken());
		}
		line = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			operator[i] = Integer.parseInt(line.nextToken());
		}
		backtrack(operator[0], operator[1], operator[2], operator[3], num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}

}
