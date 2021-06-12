package homework7;

import lectures.lecture7Graphs.Graph;
import lectures.lecture7Graphs.GraphImpl;
import lectures.lecture7Graphs.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task1 {

    private static Graph graph;

    public static void main(String[] args) {

        graph = new GraphImpl(10);
        graph.addVertex("Moscow");
        graph.addVertex("Tula");
        graph.addVertex("Ryazan");
        graph.addVertex("Kaluga");
        graph.addVertex("Lipetsk");
        graph.addVertex("Tambov");
        graph.addVertex("Orel");
        graph.addVertex("Saratov");
        graph.addVertex("Kursk");
        graph.addVertex("Voronezh");

        graph.addEdge("Moscow", "Tula", "Ryazan", "Kaluga");
        graph.addEdge("Tula", "Lipetsk");
        graph.addEdge("Ryazan", "Tambov");
        graph.addEdge("Kaluga", "Orel");
        graph.addEdge("Lipetsk", "Voronezh");
        graph.addEdge("Tambov", "Saratov");
        graph.addEdge("Orel", "Kursk");
        graph.addEdge("Saratov", "Voronezh");
        graph.addEdge("Kursk", "Voronezh");

        //graph.display();
        System.out.println(findShortestPath("Moscow", "Voronezh"));
    }

    private static LinkedList<Vertex> findShortestPath(String startLabel, String endLabel) {
        ArrayList<LinkedList<Vertex>> listOfPaths = getAllPaths(startLabel, endLabel);

        LinkedList<Vertex> shortestPath = listOfPaths.get(0);
        if (shortestPath == null){
            return null;
        }
        for (int i = 1; i < listOfPaths.size(); i++) {
            if (listOfPaths.get(i).size() < shortestPath.size()){
                shortestPath = listOfPaths.get(i);
            }
        }
        return shortestPath;
    }

    private static ArrayList<LinkedList<Vertex>> getAllPaths(String startLabel, String endLabel) {
        ArrayList<LinkedList<Vertex>> listOfPaths = new ArrayList<>();
            while (true){
                LinkedList<Vertex> path = findNextPath(startLabel, endLabel);
                if(path == null){
                    graph.resetVertexState();
                    break;
                }
                listOfPaths.add(path);
            }
        return listOfPaths;
    }

    private static LinkedList<Vertex> findNextPath(String startLabel, String endLabel) {
        LinkedList <Vertex> nextPath = new LinkedList<>();

        int startIndex = graph.indexOf(startLabel);
        int endIndex = graph.indexOf(endLabel);
        if (startIndex == -1){
            throw new IllegalArgumentException("Invalid start label: " + startLabel);
        }
        if (endIndex == -1){
            throw new IllegalArgumentException("Invalid end label: " + endLabel);
        }

        Vertex finalVertex = graph.getVertexList().get(endIndex);
        Vertex previousVertex = graph.getVertexList().get(startIndex);
        Vertex currentVertex;

        graph.visitVertex(nextPath, previousVertex);

        ArrayList<Vertex> listForSetUnvisited = new ArrayList<>();
        while (true) {
            if ((currentVertex = graph.getNearestUnvisitedVertex(previousVertex)) != null) {

                graph.visitVertex(nextPath, currentVertex);
                if (currentVertex == finalVertex) {
                    currentVertex.setUnvisited();
                    for(Vertex vertex : listForSetUnvisited){
                        vertex.setUnvisited();
                    }
                    return nextPath;
                }
                if (graph.getNearestUnvisitedVertex(previousVertex)!=null){
                    listForSetUnvisited.add(previousVertex);
                }
                previousVertex = currentVertex;
            }else{
                return null;
            }
        }
    }
}
