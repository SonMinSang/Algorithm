package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Util_12891 {

	static int[] count;
	static int checkCount;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		char[] str = new char[s];
		count = new int[4];
		checkCount = 0;
		int result = 0;
		str = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
		{
			count[i] = Integer.parseInt(st.nextToken());
			checkCount++;
		}
		for (int j = 0; j < p; j++) {
			add(str[j]);
		}
		if (checkCount == 4)
			result++;
		for (int k = p; k < s; k++) {
			add(str[k]);
			remove(str[k - p]);
			if (checkCount == 4)
				result++;
		}
		System.out.println(result);
	}
	
	static void add(char c) {
		switch(c) {
		case 'A':
			count[0]--;
			if (count[0] == 0) {
				checkCount++;
			}
			break;
		case 'C':
			count[1]--;
			if (count[1] == 0) {
				checkCount++;
			}
			break;
		case 'G':
			count[2]--;
			if (count[2] == 0) {
				checkCount++;
			}
			break;
		case 'T':
			count[3]--;
			if (count[3] == 0) {
				checkCount++;
			}
			break;
		}
		
	}
	
	static void remove(char c) {
		switch(c) {
		case 'A':
			if (count[0] == 0) {
				checkCount--;
			}
			count[0]++;
			break;
		case 'C':
			if (count[1] == 0) {
				checkCount--;
			}
			count[1]++;
			break;
		case 'G':
			if (count[2] == 0) {
				checkCount--;
			}
			count[2]++;
			break;
		case 'T':
			if (count[3] == 0) {
				checkCount--;
			}
			count[3]++;
			break;
		}
	}
}
