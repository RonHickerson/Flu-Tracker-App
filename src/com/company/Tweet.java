package com.company;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Tweet {
    private int userId;
    private String state;
    private LocalDate date;
    private Random rand = new Random();

    public Tweet() {
        userId = rand.nextInt(10) + 1;
        state = randomState();
        date = RandomDates.createRandomDate(2018, 2018);
    }

    public Tweet(int userId, String state, LocalDate date) {
        this.userId = userId;
        this.state = state;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ID: " + userId + "\nState: " + state + "\nDate: " + date + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tweet tweet = (Tweet) o;
        return userId == tweet.userId &&
                Objects.equals(state, tweet.state) &&
                Objects.equals(date, tweet.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, state, date);
    }

    private static String randomState() {
        Random rand = new Random();
        String[] states  = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HA", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WC", "WY"};
        int randNum = rand.nextInt(50);
        return states[randNum];
    }


    private static int generateRandomInteger(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}

class RandomDates {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            LocalDate randomDate = createRandomDate(1900, 2000);
            System.out.println(randomDate);
        }
    }

    public static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}