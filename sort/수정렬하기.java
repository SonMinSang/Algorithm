package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] A = new int[N];
		int temp;
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N - i + 1; j++) {
				if (A[j - 1] > A[j]) {
					temp = A[j - 1];
					A[j - 1] = A[j];
					A[j] = temp;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			sb.append(A[i] + "\n");
		}
		System.out.println(sb);
	}
}
