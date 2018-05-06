package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, Flu Tracker");
        System.out.println();
        System.out.println();

        // Create and Print Tweet files
        LList tweetList1 = new LList(10);
        LList tweetList2 = new LList(2);
        output2Nodes("Tweets", tweetList1, "More Tweets", tweetList2);


        // How many flu tweets from each state in the file?

        System.out.println("Tweets from each state: " + tweetList1.tweetsFromEachState());


//        System.out.println("Tweets from each state: " + tweetList1.tweetsFromEachState());

        // Has anyone tweeted more than once?
        System.out.println("Has anyone tweeted more than once: " + tweetList1.moreThanOneTweet());
        System.out.println("Has anyone tweeted more than once: " + tweetList2.moreThanOneTweet());

        // Which months had the most tweets?

        // Were there any clusters of tweets?  A cluster is when [C] or more consecutive tweets are from the same state.

        // Epidemic if each of any [S] states has [T] or more tweets.


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
