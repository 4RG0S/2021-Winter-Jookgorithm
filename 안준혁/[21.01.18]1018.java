import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[m][n];
		
		String temp;
		
		for(int i = 0; i < n; i++) {
			temp = br.readLine();
			for(int j = 0; j < m; j++) {
				map[j][i] = temp.charAt(j);
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		int startA, startB;
		char color = 'W';
		int count = 0;
		
		for(int i = 0; i < n - 7; i++) {
			for(int j = 0; j < m - 7; j++) {
				for(startA = i; startA < i + 8; startA++) {
					for(startB = j; startB < j + 8; startB++) {
						if(color != map[startB][startA])	count++;
						if(color == 'W') {
							color = 'B';
						} else {
							color = 'W';
						}
					}
					if(color == 'W') {
						color = 'B';
					} else {
						color = 'W';
					}
				}
				if(count < min)	min = count;
				count = 0;
			}
		}
		
		color = 'B';
		for(int i = 0; i < n - 7; i++) {
			for(int j = 0; j < m - 7; j++) {
				for(startA = i; startA < i + 8; startA++) {
					for(startB = j; startB < j + 8; startB++) {
						if(color != map[startB][startA])	count++;
						if(color == 'W') {
							color = 'B';
						} else {
							color = 'W';
						}
					}
					if(color == 'W') {
						color = 'B';
					} else {
						color = 'W';
					}
				}
				if(count < min)	min = count;
				count = 0;
			}
		}
		
		System.out.println(min);
	}
}

