package hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result_ComponentsInGraph {

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here
    	int n = gb.size();
        int[] parent = new int[2 * n + 1];
        int[] count = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            count[i] = 1;
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int g = gb.get(i).get(0);
            int b = gb.get(i).get(1);           
            int root_g = g;
            int root_b = b;
            while (parent[root_g] != root_g) root_g = parent[root_g];
            while (parent[root_b] != root_b) root_b = parent[root_b];
            if (root_b == root_g) continue;
            if (count[root_b] < count[root_g]) {
                parent[root_b] = root_g;
                count[root_g] += count[root_b];
            } else {
                parent[root_g] = root_b;
                count[root_b] += count[root_g];               
            }
        }
        int min = 2 * n + 1;
        int max = 2;
        for (int i = 1; i <= 2 * n; i++) {
            if (parent[i] != i) continue;
            if (count[i] == 1) continue;
            min = Math.min(min, count[i]);
            max = Math.max(max, count[i]);
        }
        List<Integer> result = new ArrayList<>();
        result.add(min);
        result.add(max);
        return (result);
    }

}

public class ComponentsInGraph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        List<List<Integer>> gb = new ArrayList<>();

        
        for (int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        	List<Integer> newList = new ArrayList<>();
        	newList.add(Integer.parseInt(st.nextToken()));
        	newList.add(Integer.parseInt(st.nextToken()));
        	gb.add(newList);
        }
        List<Integer> result = Result_ComponentsInGraph.componentsInGraph(gb);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
