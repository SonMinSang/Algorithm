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

   class Edge implements Comparable<Edge> {
    private int x;
    private int y;
    private double w;

    public Edge(int x, int y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public double getW() {
        return this.w;
    }

    public int compareTo(Edge b) {
        if (this.w < b.w) {
            return -1;
        } else if (this.w > b.w) {
            return 1;
        }
        return 0;
    }
}

class Node {
    private int id;
    private HashSet<Integer> members = new HashSet<Integer>();

    Node(int id) {
        this.id = id;
        this.members.add(this.id);
    }

    public int getId() {
        return this.id;
    }

    public void setMembers(HashSet<Integer> m) {
        this.members = m;
    }

    public HashSet<Integer> getMembers() {
        return this.members;
    }

    public boolean hasMember(int id) {
        return this.members.contains(id);
    }
}


class Result {

    /*
     * Complete the 'kruskals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
     */

    /*
     * For the weighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] and <name>To[i]. The weight of the edge is <name>Weight[i].
     *
     */
    
 
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        
        ArrayList<Edge> edges = new ArrayList<Edge>();
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Edge> path = new ArrayList<Edge>();
        
        for (int i = 1; i <= gNodes; i++) {
            nodes.add(new Node(i));
        }

        for (int i = 0; i < gWeight.size(); i++) {
            int x = gFrom.get(i);
            int y = gTo.get(i);
            int w = gWeight.get(i);

            Edge tmp = new Edge(x, y, w);
            edges.add(tmp);
        }

        Collections.sort(edges);

        for (int i = 0; i < edges.size(); i++) {
            Edge tmp = edges.get(i);
            int indexX = tmp.getX()-1;
            int indexY = tmp.getY()-1;

            Node x = nodes.get(indexX);
            Node y = nodes.get(indexY);

            if (!x.hasMember(y.getId())) {
                path.add(tmp);

                HashSet<Integer> m = x.getMembers();
                m.addAll(y.getMembers());

                Iterator<Integer> iterator = m.iterator();
                while (iterator.hasNext()) {
                    Integer current = iterator.next();
                    nodes.get(current-1).setMembers(m);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < path.size(); i++) {
            sum += path.get(i).getW();
        }
        return(sum);
    }

}

public class Kruskal {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int gNodes = Integer.parseInt(st.nextToken());
        int gEdges = Integer.parseInt(st.nextToken());

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        for (int i = 0; i < gNodes; i++) {

            st = new StringTokenizer(bufferedReader.readLine());
            gFrom.add(Integer.parseInt(st.nextToken()));
            gTo.add(Integer.parseInt(st.nextToken()));
            gWeight.add(Integer.parseInt(st.nextToken()));
        }

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // Write your code here.
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}