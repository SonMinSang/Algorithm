package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수_구하기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] result = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < N; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				result[stack.pop()] = A[i];
			} 
			stack.push(i);
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        for (int ans : result){
			sb.append(String.valueOf(ans)).append(" ");
		}
		System.out.println(sb);
	}
}
