package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Friend {
    private final static Pattern foundStringsPattern = Pattern.compile("\\d{4}\\s+\\d+\\s+(\\d{4}\\s*)+");
    private List<String> friends = new ArrayList<>();
    private String friendName;

    public Friend(String string) {
        if (!foundStringsPattern.matcher(string).matches()) throw new IllegalArgumentException("Invalid");
        String[] stringParts = string.split("\\s+");
        this.friendName = stringParts[0];
        List<String> friends = Arrays.asList(stringParts).subList(2, stringParts.length);
        this.friends.addAll(friends);
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getFriendName() {
        return friendName;
    }
}
