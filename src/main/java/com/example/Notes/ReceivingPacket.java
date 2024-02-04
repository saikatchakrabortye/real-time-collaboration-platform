package com.example.Notes;

public class ReceivingPacket {
    String senderUsername;
    String groupToShare;
    String title;
    String description;
    public ReceivingPacket(String senderUsername, String groupToShare, String title, String description) {
        this.senderUsername = senderUsername;
        this.groupToShare = groupToShare;
        this.title = title;
        this.description = description;
    }
    public String getSenderUsername() {
        return senderUsername;
    }
    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }
    public String getGroupToShare() {
        return groupToShare;
    }
    public void setGroupToShare(String groupToShare) {
        this.groupToShare = groupToShare;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
