package January;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class January_27_1269 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine());
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		
		line = new StringTokenizer(br.readLine());
		while(line.hasMoreElements())
			A.add(Integer.parseInt(line.nextToken()));
		line = new StringTokenizer(br.readLine());
		while(line.hasMoreElements())
			B.add(Integer.parseInt(line.nextToken()));
		
		int a_size = A.size();
		int b_size = B.size();
		
		for(Object in_A : A.toArray()) {
			if(B.contains(in_A))
				b_size--;
		}
		for(Object in_B : B.toArray()) {
			if(A.contains(in_B))
				a_size--;
		}
		System.out.println(a_size + b_size);
	}

}
