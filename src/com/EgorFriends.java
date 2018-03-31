package com;

import com.GraphClasses.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EgorFriends {

    private List<Friend> friendList = new ArrayList<>();
    private final static String EGOR_ID = "0000";

    public void start() {
        String inputString = new Scanner(System.in).nextLine();
        while (true) {
            inputString = new Scanner(System.in).nextLine();
            if (inputString.equals("end")) break;
            Friend friend = new Friend(inputString);
            friendList.add(friend);
        }
        getFriendOfFriend();
    }

    public void getFriendOfFriend() {
        Graph graph = new Graph();
        addToGraph(graph);
        System.out.printf("Egor has %d friends of friends", graph.searchNotNeighbors(EGOR_ID).size());
    }

    private void addToGraph(Graph graph) {
        graph.addVertex(EGOR_ID);
        for (Friend friend : friendList) {
            String mainFriend = friend.getFriendName();

            graph.addVertex(mainFriend);
            graph.connect(EGOR_ID, mainFriend);

            graph.addAllVertexes(friend.getFriends());
            friend.getFriends().forEach((String friendName) -> {
                graph.connect(mainFriend, friendName);
            });
        }
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }
}
