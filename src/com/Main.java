package com;

import com.GraphClasses.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Friend friend = new Friend("4578 5 1256 4323 1897 3244 5678");
        Friend friend1 = new Friend("1256 2 4578 1897");
        Friend friend2 = new Friend("4323 4 5678 6547 9766 9543");
        Friend friend3 = new Friend("9766 1 3624");
        List<Friend> friends = new ArrayList<>(Arrays.asList(friend, friend1, friend2, friend3));

        EgorFriends egorFriends = new EgorFriends();
        egorFriends.setFriendList(friends);
        egorFriends.getFriendOfFriend();
    }
}
