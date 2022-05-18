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

class Prim_Result {

    /*
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */

    static int[] distances;
    static int[][] matrix;
    static Set<Integer> visited;
    static boolean[] vis;
    static int minEdge;
    static int min = 0;
    
    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
        matrix = new int[n + 1][n + 1];
        int edgesCount = edges.size();
        visited = new HashSet<>();
        vis = new boolean[n + 1];
        for (int i = 0; i < edgesCount; i++) {
            int source = edges.get(i).get(0);
            int target = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            matrix[source][target] = weight == 0 ? -1 : weight;
            matrix[target][source] = weight == 0 ? -1 : weight;
        }
        visited.add(start);
        vis[start] = true;
        int sum = 0;
        while (visited.size() != n) {
            minEdge = 0;
            min = Integer.MAX_VALUE;

            for (Integer in : visited) {

                getNeighbours(in);
            }

            if (min == -1) {
                min = 0;
            }
            sum += min;

            visited.add(minEdge);
            vis[minEdge] = true;

        }
        return(sum);
    }
    
    static void getNeighbours(int node) {
        for (int in = 0; in < matrix[node].length; in++) {
            if (in != 0 && in != node) {
                if (!vis[in] && matrix[node][in] != 0) {
                    if (min > matrix[node][in]) {
                        minEdge = in;
                        min = matrix[node][in];
                    }
                }
            }
        }
    }

}

public class Prim {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Prim_Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}