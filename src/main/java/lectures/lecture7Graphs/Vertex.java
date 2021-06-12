package lectures.lecture7Graphs;

import java.util.Objects;

public class Vertex {

    private final String label; // Значение вершиныю Обозначение того, что она из себя представляет.
    private boolean visited;

    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vertex)) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(getLabel(), vertex.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel());
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setUnvisited() {
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }
}
