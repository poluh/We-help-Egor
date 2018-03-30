package com.GraphClasses;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertexes = new ArrayList<>();

    public void addVertex(String vertexName) {
        this.vertexes.add(new Vertex(vertexName));
    }

    public void addAllVertexes(String... vertexNames) {
        for (String vertexName : vertexNames) {
            this.vertexes.add(new Vertex(vertexName));
        }
    }

    public void connect(String fromName, String toName) {
        Vertex from = new Vertex(fromName);
        Vertex to = new Vertex(toName);
        if (!this.vertexes.contains(from) || !this.vertexes.contains(to)) throw new IllegalArgumentException();
        from.addNeighbor(to);
        to.addNeighbor(from);
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public boolean isConnect(String fromName, String toName) {
        Vertex from = new Vertex(fromName);
        Vertex to = new Vertex(toName);
        return from.isNeighbor(to);
    }
}
