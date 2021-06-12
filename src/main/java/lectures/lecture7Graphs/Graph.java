package lectures.lecture7Graphs;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

public interface Graph {

    void addVertex(String label);

    //boolean addEdge(String startLabel, String endLabel); // добавляем связи (ребра)

    boolean addEdge(String startLabel, String secondLabel, String ... others );

    int getSize();

    void display();

    void dfs(String startLabel);  // Depth-first search, поиск в глубину

    void bfs(String startLabel); // breadth-first search, поиск в ширину

    int indexOf(String startLabel);

    List<Vertex> getVertexList();

    void visitVertex(Stack<Vertex> stack, Vertex vertex);

    void visitVertex(Queue<Vertex> queue, Vertex vertex);

    Vertex getNearestUnvisitedVertex(Vertex current);

    void resetVertexState();


}
