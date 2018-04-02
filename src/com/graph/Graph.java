package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, Vertex> vertexes = new HashMap<>();

    public void addVertex(String vertexName) {
        if (!this.vertexes.containsKey(vertexName)) {
            this.vertexes.put(vertexName, new Vertex(vertexName));
        }
    }

    public void addAllVertexes(List<String> vertexNames) {
        vertexNames.forEach((String vertexName) -> {
            if (!this.vertexes.containsKey(vertexName)) {
                this.vertexes.put(vertexName, new Vertex(vertexName));
            } else {
                System.err.printf("Vertex %s exist", vertexName);
            }
        });

    }

    public void connect(String fromName, String toName) {
        if (!this.vertexes.containsKey(fromName) || !this.vertexes.containsKey(toName)) {
            System.err.println("Vertex don't exist");
            return;
        }
        this.vertexes.get(fromName).addNeighbor(this.vertexes.get(toName));
        this.vertexes.get(toName).addNeighbor(this.vertexes.get(fromName));
    }

    public boolean isConnect(String fromName, String toName) {
        if (!this.vertexes.containsKey(fromName) || !this.vertexes.containsKey(toName)) {
            System.err.println("Vertex don't exist");
            return false;
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
        if (answer.size() == 0) {
            System.err.println("Vertexes not search");
        }
        return answer;
    }
}
