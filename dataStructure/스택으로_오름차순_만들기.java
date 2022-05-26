package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택으로_오름차순_만들기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		int num = 1;
		for (int i = 0; i < A.length; i++) {
			int curr = A[i];
			if (curr >= num) {
				while(curr >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
				stack.pop();
				sb.append("-\n");
			} else {
				int top = stack.pop();
				if (top > curr) {
					System.out.println("NO");
					return ;
				} else if (top == curr) {
					sb.append("-\n");
				}
			}
		}
		System.out.println(sb);
	}
}
