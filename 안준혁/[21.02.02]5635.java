import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
	String name;
	int day, month, year;
	
	Person(String name, int day, int month, int year) {
		this.name = name;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Person o) {
		int compare1, compare2, compare3;
		compare1 = this.year - o.year;
		compare2 = this.month - o.month;
		compare3 = this.day - o.day;
		if(compare1 == 0) {
			if(compare2 == 0) {
				return compare3;
			}
			else {
				return compare2;
			}
		}
		else {
			return compare1;
		}
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		ArrayList<Person> students = new ArrayList<Person>();
		
		String name;
		int day, month, year;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			students.add(new Person(name, day, month, year));
		}
		
		Collections.sort(students);
		
		System.out.println(students.get(n-1).name);
		System.out.println(students.get(0).name);
	}
}

