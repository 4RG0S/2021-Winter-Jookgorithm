import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		int a;
		int temp;
		
		for(int i = 1; i <= n; i++) {
			a = 0;
			temp = sigma(i);
			while(i > a && temp > n) {
				temp = sigma(i);
				temp -= sigma(a);
				a++;
			}
			if(temp == n) {
				count++;
			}
		}
		
		
		System.out.println(count);
	}
	
	static int sigma(int n) {
		return n*(n+1)/2;
	}
}