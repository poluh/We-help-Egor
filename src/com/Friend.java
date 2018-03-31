package com;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Friend {
    private final static Pattern foundStringsPattern = Pattern.compile("\\d{4}\\s+\\d+\\s+(\\d{4}\\s*)+");
    private List<String> friends;
    private String friendName;

    Friend(String string) {
        if (!foundStringsPattern.matcher(string).matches()) throw new IllegalArgumentException("Invalid");
        String[] stringParts = string.split("\\s+");
        this.friendName = stringParts[0];
        this.friends.addAll(Arrays.asList(stringParts).subList(2, stringParts.length));
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
