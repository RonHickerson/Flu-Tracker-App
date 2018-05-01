package com.company;

public class LList {
    private Tweet tweet;
    private LList next;

    public LList() {
        this.next = null;
        this.tweet = new Tweet();
    }

    public LList(Tweet tweet) {
        this.tweet = tweet;
        this.next = null;
    }

//    TODO:
//   public int add(Tweet tweet) {
//
//    }

//    TODO:
//   public int get(int index) {
//
//    }

//    TODO:
//    public int size() {
//
//    }



    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        LList temp = this;
        while (temp.next != null) {
            sb.append(temp.tweet).append("-");
            temp = temp.next;
        }
        sb.append(temp.tweet);
        return sb.toString();
    }

}
