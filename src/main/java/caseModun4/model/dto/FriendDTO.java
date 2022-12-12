package caseModun4.model.dto;

import caseModun4.model.Friend;
import caseModun4.model.FriendStatus;

public class FriendDTO {
    private long idFriend;

    private FriendStatus friendStatus;

    public FriendDTO() {
    }

    public FriendDTO(long idFriend, FriendStatus friendStatus) {
        this.idFriend = idFriend;
        this.friendStatus = friendStatus;
    }

    public long getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(long idFriend) {
        this.idFriend = idFriend;
    }

    public FriendStatus getFriendStatus() {
        return friendStatus;
    }

    public void setFriendStatus(FriendStatus friendStatus) {
        this.friendStatus = friendStatus;
    }
}
