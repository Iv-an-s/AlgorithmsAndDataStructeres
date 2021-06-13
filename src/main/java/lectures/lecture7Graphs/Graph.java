package lectures.lecture7Graphs;

public interface Graph {

    void addVertex(String label);

    //boolean addEdge(String startLabel, String endLabel); // добавляем связи (ребра)

    boolean addEdge(String startLabel, String secondLabel, String ... others );

    int getSize();

    void display();

    void dfs(String startLabel);  // Depth-first search, поиск в глубину

    void bfs(String startLabel); // breadth-first search, поиск в ширину




}
