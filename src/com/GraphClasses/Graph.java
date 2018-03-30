package com.GraphClasses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

public class Graph {

    private Map<String, Vertex> vertexes = new HashMap<>();

    public void addVertex(String vertexName) {
        this.vertexes.put(vertexName, new Vertex(vertexName));
    }

    public void addAllVertexes(String... vertexNames) {
        for (String vertexName : vertexNames) {
            this.vertexes.put(vertexName, new Vertex(vertexName));
        }
    }

    public void connect(String fromName, String toName) {
        if (!this.vertexes.containsKey(fromName) || !this.vertexes.containsKey(toName)) {
            throw new IllegalArgumentException();
        }
        this.vertexes.get(fromName).addNeighbor(this.vertexes.get(toName));
        this.vertexes.get(toName).addNeighbor(this.vertexes.get(fromName));
    }

    public Map<String, Vertex> getVertexes() {
        return vertexes;
    }

    public boolean isConnect(String fromName, String toName) {
        if (!this.vertexes.containsKey(fromName) || !this.vertexes.containsKey(toName)) {
            throw new IllegalArgumentException();
        }
        return this.vertexes.get(fromName).isNeighbor(this.vertexes.get(toName));
    }

    public List<Vertex> searchNotNeighbors(String vertexName) {
        List<Vertex> neighbors = this.vertexes.get(vertexName).getNeighbors();
        List<Vertex> answer = new ArrayList<>();
        this.vertexes.forEach((String vertexKey, Vertex vertex) -> {
            if (!neighbors.contains(vertex) && !vertexKey.equals(vertexName)) {
                answer.add(vertex);
            }
        });
        return answer;
    }
}
