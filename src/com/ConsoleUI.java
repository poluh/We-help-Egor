package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    public static void start() {
        Scanner inputScanner = new Scanner(System.in);

        // read friends count
        int friendCount;
        try {
            friendCount = Integer.valueOf(inputScanner.nextLine());
        } catch (Exception e) {
            System.err.print("Invalid friends count!");
            return;
        }
        if (friendCount < 1 || friendCount > 100) {
            System.err.print("Invalid friends count!");
            return;
        }

        // read friends
        List<Friend> friendList = new ArrayList<>();
        for (int i = 1; i <= friendCount; i++) {
            try {
                friendList.add(new Friend(inputScanner.nextLine()));
            } catch (Exception e) {
                System.err.print("Invalid friend!");
                return;
            }
        }

        System.out.print(new EgorFriends(friendList).getFriendOfFriend());
    }
}
