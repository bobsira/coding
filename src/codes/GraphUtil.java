package codes;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphUtil {

    static class Graph {

        int V;
        LinkedList<Integer> adjListArray[];

        Graph(int V){
            this.V = V;
            adjListArray = new LinkedList[V];
            for(int i =0; i < V; i++)
                adjListArray[i] = new LinkedList<>();
        }

    }

    private static void addEdge(Graph graph, int source, int destination){
        graph.adjListArray[source].add(destination);
        graph.adjListArray[destination].add(source);
    }

    private static void printGraph(Graph graph){
        for (int v = 0; v < graph.V; v++) {
            System.out.print("Adjacency list vertex " + v + " ");
            for (Integer pCrawl : graph.adjListArray[v])
                System.out.print("-> " + pCrawl);
            System.out.println();
        }
    }

    private static void BFS(Graph graph, int source){
        boolean visited[] = new boolean[graph.V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty()){
            int current_vertex = queue.poll();
            System.out.print(current_vertex + " ");
            Iterator<Integer> iterator = graph.adjListArray[current_vertex].listIterator();
            while (iterator.hasNext()){
                int vertex = iterator.next();
                if (!visited[vertex]){
                    visited[vertex] = true;
                    queue.add(vertex);
                }
            }
        }
    }

    private static void DFS(Graph graph, int source){
        boolean visited[] = new boolean[graph.V];
        DFSUtil(graph,source,visited);
    }
    private static void DFSDisconnected(Graph graph){
        boolean visited[] = new boolean[graph.V];
        for (int vertex = 0; vertex < graph.V; vertex ++){
            if (!visited[vertex])
                DFSUtil(graph,vertex,visited);
        }
    }
    private static void DFSUtil(Graph graph, int source, boolean[] visited){
        visited[source] = true;
        System.out.print(source + " ");
        Iterator<Integer> iterator = graph.adjListArray[source].listIterator();
        while (iterator.hasNext()){
            int vertex = iterator.next();
            if (!visited[vertex])
                DFSUtil(graph,vertex,visited);
        }
    }


    public static void main(String[] args) {
        Graph graph = new Graph(7);
        addEdge(graph,0,1);
        addEdge(graph,0,4);
        addEdge(graph,1,2);
        addEdge(graph,1,3);
        addEdge(graph,1,4);
        addEdge(graph,2,3);
        addEdge(graph,3,4);

        addEdge(graph,5,6);

        DFSDisconnected(graph);
    }
}
