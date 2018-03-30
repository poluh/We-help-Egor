package com.GraphClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {

    private String vertexName;
    private boolean isVisited = false;
    private List<Vertex> neighbors;

    Vertex(String vertexName) {
        neighbors = new ArrayList<>();
        this.vertexName = vertexName;
    }

    public String getVertexName() {
        return vertexName;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public void addNeighbor(Vertex vertex) {
        this.neighbors.add(vertex);
    }

    public boolean isNeighbor(Vertex vertex) {
        return this.neighbors.contains(vertex);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() && this.vertexName.equals(((Vertex) obj).vertexName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertexName, isVisited, neighbors);
    }
}
