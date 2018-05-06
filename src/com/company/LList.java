package com.company;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

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
    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder("");
        LList temp = this;
        while (temp.next != null) {
            sb.append(temp.tweet).append("-");
            temp = temp.next;
        }
        sb.append(temp.tweet);
        return sb.toString();
    }


    public Map<String, Integer> tweetsFromEachState() {
        Map<String, Integer> counts = new HashMap<>();
        LList temp = this;
        while (temp.next != null) {
            if(counts.isEmpty())
                counts.put(temp.tweet.getState(), 0);
            if(!counts.containsKey(temp.tweet.getState()))
                counts.put(temp.tweet.getState(), 1);
            else if (counts.containsKey(temp.tweet.getState())) {
                int count = counts.get(temp.tweet.getState());
                counts.put(temp.tweet.getState(), count + 1);
            }
            temp = temp.next;
        }
        return counts;
    }

    public boolean moreThanOneTweet(){
        LList temp = this;
        ArrayList<Integer> ids = new ArrayList<>();
        while (temp.next != null) {
            ids.add(temp.tweet.getUserId());
            temp = temp.next;
        }
        Set<Integer> duplicates = new HashSet<>();
        for (int nums : ids) {
            if (!duplicates.add(nums))
                return true;
        }
        return false;
    }

    public Month monthWithMostTweets() {
        Map<Month, Integer> counts = new HashMap<>();
        LList temp = this;
        while (temp.next != null) {
            if (counts.isEmpty())
                counts.put(temp.tweet.getDate().getMonth(), 0);
            if (!counts.containsKey(temp.tweet.getDate().getMonth()))
                counts.put(temp.tweet.getDate().getMonth(), 1);
            else if (counts.containsKey(temp.tweet.getDate().getMonth())) {
                int count = counts.get(temp.tweet.getDate().getMonth());
                counts.put(temp.tweet.getDate().getMonth(), count + 1);
            }
            temp = temp.next;
        }
        int maxValueInMap = (Collections.max(counts.values()));
        for (Map.Entry<Month, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                return entry.getKey();


            }
        }
        return temp.getTweet().getDate().getMonth();
    }


    public boolean isClusterPresent(int consecutiveNum) {
        LList temp = this;
        while (temp.next != null) {
            if (tweetsFromEachState().get(temp.tweet.getState()) >= consecutiveNum)
                return true;
            temp = temp.next;
        }
        return false;
    }

}