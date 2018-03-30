package com.main.Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String vertexName;
    private boolean isVisited = false;
    private List<Vertex> neighbors = new ArrayList<>();

    Vertex(String vertexName) {
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

    @Override
    public boolean equals(Object obj) {
        return this.getClass() == obj.getClass() && this.vertexName.equals(((Vertex) obj).vertexName);
    }
}
