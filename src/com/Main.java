package com;

import com.GraphClasses.Graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addAllVertexes("A", "B", "C", "D", "E", "F", "G", "H");
        graph.connect("A", "B");
        graph.connect("A", "C");
        graph.connect("A", "D");
        graph.connect("A", "H");
        graph.connect("B", "E");
        graph.connect("B", "F");
        graph.connect("B", "G");
        graph.connect("C", "G");
        graph.connect("D", "H");

        System.out.println(graph.isConnect());
    }
}
