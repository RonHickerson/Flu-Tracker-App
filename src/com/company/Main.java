package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Flu Tracker");
        System.out.println();
        System.out.println();

        // Create and Print Tweet files
        LList tweetList = new LList(10);
        output1Node("Tweets", tweetList);

        //

    }

    public static void output1Node(String s, LList n) {
        System.out.println(s + ":\t" + n);
    }

    public static void output2Nodes(String s1, LList n1, String s2, LList n2) {
        output1Node(s1, n1);
        output1Node(s2, n2);
    }

    public static void output3Nodes(String s1, LList n1, String s2, LList n2, String s3, LList n3) {
        output1Node(s1, n1);
        output1Node(s2, n2);
        output1Node(s3, n3);
    }




}
