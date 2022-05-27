package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 버블소트2 {
	static int[] A, tmp;
	static int result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		result = 0;
		merge(0, N - 1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(A[i] + "\n");
		}
		System.out.println(sb);
		System.out.println(result);
	}

	private static void merge(int start, int end) {
		if (end - start < 1) 
			return ;
		int m = (start + end) /2 ;
		merge(start, m);
		merge(m + 1, end);
		
		for (int i = start; i <= end; i++) {
			A[i] = tmp[i];
		}
		int i = start;
		int j = m + 1;
		int index = start;
		while (i <= m && j <= end) {
			if (tmp[i] > tmp[j]) {
				A[index] = tmp[j];
				result = result + j - index;
				j++;
				index++;
			} else {
				A[index] = tmp[i];
				i++;
				index++;
			}
		} 
		while (i <= m) {
			A[index] = tmp[i];
			i++;
			index++;
		}
		while (j <= end) {
			A[index] = tmp[j];
			j++;
			index++;
		}
	}
}