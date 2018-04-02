package com;

import com.graph.Graph;

import java.util.List;

public class EgorFriends {

    private List<Friend> friendList;
    private final static String EGOR_ID = "0000";

    public EgorFriends(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public int getFriendOfFriend() {
        Graph graph = new Graph();
        addToGraph(graph);
        return graph.searchNotNeighbors(EGOR_ID).size();
    }

    private void addToGraph(Graph graph) {
        graph.addVertex(EGOR_ID);
        friendList.forEach((Friend friend) -> {
                    String mainFriend = friend.getFriendName();

                    graph.addVertex(mainFriend);
                    graph.connect(EGOR_ID, mainFriend);

                    graph.addAllVertexes(friend.getFriends());
                    friend.getFriends().forEach((String friendName) -> {
                        graph.connect(mainFriend, friendName);
                    });
                }
        );
    }
}
