import com.EgorFriends;
import com.Friend;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EgorFriendsTest {

    @Test
    void exampleTest() {
        Friend friend = new Friend("4578 5 1256 4323 1897 3244 5678");
        Friend friend1 = new Friend("1256 2 4578 1897");
        Friend friend2 = new Friend("4323 4 5678 6547 9766 9543");
        Friend friend3 = new Friend("9766 1 3624");
        List<Friend> friends = new ArrayList<>(Arrays.asList(friend, friend1, friend2, friend3));

        EgorFriends egorFriends = new EgorFriends(friends);
        assertEquals(6, egorFriends.getFriendOfFriend());
    }

    @Test
    void advancedTest() {
        List<Friend> friends = new ArrayList<>(Arrays.asList(
                new Friend("0001 2 0002 0003"),
                new Friend("0002 2 0001 0003"),
                new Friend("0003 2 0002 0003")));
        EgorFriends egorFriends = new EgorFriends(friends);
        assertEquals(0, egorFriends.getFriendOfFriend());

        friends = new ArrayList<>(Arrays.asList(
                new Friend("0001 1 0002"),
                new Friend("0002 1 0001"),
                new Friend("0003 1 0001")));
        egorFriends = new EgorFriends(friends);
        assertEquals(0, egorFriends.getFriendOfFriend());

        friends = new ArrayList<>(Arrays.asList(
                new Friend("0001 4 0004 0005 0006 0007"),
                new Friend("0002 4 0004 0005 0006 0007"),
                new Friend("0003 4 0004 0005 0006 0007")));
        egorFriends = new EgorFriends(friends);
        assertEquals(4, egorFriends.getFriendOfFriend());

        friends = new ArrayList<>(Arrays.asList(
                new Friend("0001 1 0002"),
                new Friend("0002 4 0004 0005 0006 0007"),
                new Friend("0003 4 0008 0009 0010 0011")));
        egorFriends = new EgorFriends(friends);
        assertEquals(8, egorFriends.getFriendOfFriend());
    }
}
