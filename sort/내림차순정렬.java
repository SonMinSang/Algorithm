package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 내림차순정렬 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] A = new int[str.length()];
		int max;
		int temp;
		for (int i = 0; i < str.length(); i++) {
			A[i] = Integer.parseInt(str.substring(i, i + 1));
		}
		for (int i = 0; i < str.length(); i++) {
			max = i;
			for (int j = i + 1; j < str.length(); j++) {
				if (A[max] < A[j]) {
					max = j;
				}
			}
			if (A[max] > A[i]) {
				temp = A[max];
				A[max] = A[i];
				A[i] = temp;
			}
		}
		for (int i : A) {
			System.out.print(i);
		}
	}
}
