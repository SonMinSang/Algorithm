package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class K번째수 {

	static int[] A;
	static int N;
	static int K;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		quicksort(0, N-1);
		System.out.println(A[K - 1]);
	}
	
	public static void quicksort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			if (K - 1 < pivot) {
				partition(start, pivot - 1);
			} else if (K - 1 == pivot){
				return ;
			} else {
				partition(pivot + 1, end);
			}
		}
	}
	public static int partition(int start, int end) {
		int m = (start + end) / 2;
		int i = start;
		int j = end;
		swap(start, m);
		int pivot = A[start];
		while (i < j) {
			while ( A[j] > pivot) {
				j--;
			}
			while (i < j && A[i] <= pivot) {
				i++;
			} 
			swap(i, j);
		}
		A[start] = A[i];
		A[i] = pivot;
		return i;
	}
	public static void swap(int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}
