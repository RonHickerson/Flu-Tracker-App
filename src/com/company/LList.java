package com.company;

import java.util.HashMap;
import java.util.Map;

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

    public LList(int size) {
        tweet = new Tweet();
        next = null;
        if (size > 1) {
            next = new LList(size - 1);
        }
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public LList getNext() {
        return next;
    }

    public void setNext(LList next) {
        this.next = next;
    }

    public boolean add(Tweet tweet) {
        LList end = new LList(tweet);
        LList temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = end;
        return true;
    }


    public Object get(int index) {
        LList temp = this;
        if (index < 0)
            return null;
        if (temp != null) {
            temp = this.getNext();
            for (int i = 0; i < index; i++) {
                if (temp.getNext() == null)
                    return null;
                temp = temp.getNext();
            }
                return temp.getTweet();
    }
            return temp;
        }

    public int size(LList head) {
        if (head == null) {
            return 0;
        } else
            return 1 + size(head.next);
    }
    
    public Map<String, Integer> tweetsFromEachState() {
        Map<String, Integer> counts = new HashMap<>();
        int count = 0;
        LList temp = this;
        while (temp != null) {
            if (temp.getTweet().getState().equals(counts.) ) {
                count++;
            }
            counts.put(temp.getTweet().getState(), count);
        }
    return counts;
    }

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
