/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.altyjp.webChangeDetector;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author satouryou
 */
public class TweetStrings {

    //ここは各自設定すること
    private final String ConsumerKey= "";
    private final String ConsumerSecret = "";
    private final String AccessToken = "";
    private final String AccessTokenSecret = "";
    
    /**
     * 文字列をツイートする
     *
     * @param str_tweet
     * @throws TwitterException
     */
    public void tweetString(String str_tweet) throws TwitterException {

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(ConsumerKey)
                .setOAuthConsumerSecret(ConsumerSecret)
                .setOAuthAccessToken(AccessToken)
                .setOAuthAccessTokenSecret(AccessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        //User user = twitter.verifyCredentials();
        //ユーザ情報取得
        //System.out.println("なまえ　　　：" + user.getName());
        //System.out.println("ひょうじ名　：" + user.getScreenName());
        //System.err.println("ふぉろー数　：" + user.getFriendsCount());
        //System.out.println("ふぉろわー数：" + user.getFollowersCount());
        //ついーとしてみる
        Status status = twitter.updateStatus(str_tweet);
    }
}
