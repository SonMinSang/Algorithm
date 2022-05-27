package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		Inode[] A = new Inode[N];
		for (int i = 0; i < N; i++) {
			A[i] = new Inode(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(A);
		for (int i = 0; i < N; i++) {
			if (max < A[i].index -i)
				max = A[i].index - i;
		}
		System.out.println(max + 1);
	}

}
class Inode implements Comparable<Inode>{
	
	int value;
	int index;
	
	public Inode(int value, int index) {
		this.value = value;
		this.index = index;
	}
	
	public int compareTo(Inode o) {
		return this.value - o.value;
	}
}