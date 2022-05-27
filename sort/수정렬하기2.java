package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기2 {
		static int[] A, tmp;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		A = new int[N];
		tmp = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		merge(0, N - 1);
		for (int i = 0; i < N; i++) {
			sb.append(A[i] + "\n");
		}
		System.out.println(sb);
	}
	private static void merge(int start, int end) {
		
		if (end - start < 1)
			return ;
		int m = (start + end) / 2;
		
		merge(start, m);
		merge(m + 1, end);
		for (int i = start; i <= end; i++) {
			tmp[i] = A[i];
		}
		int i = start;
		int j = m + 1;
		int index = start;
		while (i <= m && j <= end) {
			if (tmp[i] > tmp[j]) {
				A[index] = tmp[j];
				index++;
				j++;
			} else {
				A[index] = tmp[i];
				index++;
				i++;
			}
		}
		while (i <= m) {
			A[index] = tmp[i];
			index++;
			i++;
		}
		while (j <= end) {
			A[index] = tmp[j];
			index++;
			j++;
		}
	}
}
