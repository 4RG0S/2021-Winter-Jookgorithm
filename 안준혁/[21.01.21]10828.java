import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String instruction;
		
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			instruction = st.nextToken();		
			if(instruction.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			}	else if(instruction.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}		
			}	else if(instruction.equals("size")) {
				System.out.println(stack.size());
			}	else if(instruction.equals("empty")) {
				if(stack.isEmpty()) {
					System.out.println(1);
				}else	{
					System.out.println(0);
				}
			}	else if(instruction.equals("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
			}	
		}
	}
}

