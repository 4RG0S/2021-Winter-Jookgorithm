import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	String name;
	int korean, english, math;
	
	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;		
	}

	@Override
	public int compareTo(Student o) {
		int compare1 = o.korean - this.korean;
		int compare2 = this.english - o.english;
		int compare3 = o.math - this.math;
		
		if(compare1 == 0) {
			if(compare2 == 0) {
				if(compare3 == 0) {
					return this.name.compareTo(o.name);
				}
				else {
					return compare3;
				}
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
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		String name;
		int korean, english, math;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			korean = Integer.parseInt(st.nextToken());
			english = Integer.parseInt(st.nextToken());
			math = Integer.parseInt(st.nextToken());
			students.add(new Student(name, korean, english, math));
		}
		
		Collections.sort(students);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < students.size(); i++) {
			sb.append(students.get(i).name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

