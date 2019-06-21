package codes;

import java.util.*;

public class BigThree {


    public static class GraphUtility {
        private static class Graph {
            int V;
            LinkedList<Integer> adjListArray[];

            Graph(int V){
                this.V = V;
                adjListArray = new LinkedList[V];

                // Create a new list for each vertex
                // such that adjacent nodes can be stored
                for (int i = 0; i < V; i++) {
                    adjListArray[i] = new LinkedList<>();
                }
            }
        }

        static void addEdge(Graph graph, int source, int destination){
            graph.adjListArray[source].add(destination);
            graph.adjListArray[destination].add(source);
        }

        // A utility function to print the adjacency list representation of graph
        static void printGraph(Graph graph){
            for (int v = 0; v < graph.V; v++) {
                System.out.println("Adjacency list of vertex "+ v);
                System.out.print("Head");
                for (Integer pCrawl: graph.adjListArray[v]){
                    System.out.print("->" +pCrawl);
                }
                System.out.println("\n");
            }
        }

        static void BFS(Graph graph, int s) {
            // Mark all the vertices as not visited(By default
            // set as false)
            boolean visited[] = new boolean[graph.V];

            // Create a queue for BFS
            LinkedList<Integer> queue = new LinkedList<Integer>();

            // Mark the current node as visited and enqueue it
            visited[s]=true;
            queue.add(s);

            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                s = queue.poll();
                System.out.print(s+" ");

                // Get all adjacent vertices of the dequeued vertex s
                // If a adjacent has not been visited, then mark it
                // visited and enqueue it
                Iterator<Integer> i = graph.adjListArray[s].listIterator();
                while (i.hasNext()) {
                    int n = i.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }

        // A function used by DFS
        static void DFSUtil(Graph graph, int v, boolean visited[]) {
            // Mark the current node as visited and print it
            visited[v] = true;
            System.out.print(v+" ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = graph.adjListArray[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(graph,n, visited);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        static void DFS(Graph graph, int v) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[graph.V];

            // Call the recursive helper function to print DFS traversal
            DFSUtil(graph,v, visited);
        }

        static void DFSDisconnected(Graph graph) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[graph.V];

            // Call the recursive helper function to print DFS traversal
            // starting from all vertices one by one
            for (int i=0; i<graph.V; ++i)
                if (!visited[i])
                    DFSUtil(graph, i, visited);
        }

        public static void main(String args[]) {
            // create the graph given in above figure
            int V = 5;
            Graph graph = new Graph(V);
            addEdge(graph, 0, 1);
            addEdge(graph, 0, 4);
            addEdge(graph, 1, 2);
            addEdge(graph, 1, 3);
            addEdge(graph, 1, 4);
            addEdge(graph, 2, 3);
            addEdge(graph, 3, 4);

            // print the adjacency list representation of
            // the above graph
            //printGraph(graph);


            //System.out.println("Following is Breadth First Traversal "+
                    //"(starting from vertex 2)");

            //BFS(graph, 2);

            //System.out.println("Following is Depth First Traversal "+
                    //"(starting from vertex 2)");

            //DFS(graph,2);
            DFSDisconnected(graph);
        }
    }
}
